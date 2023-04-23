package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.domain.entities.Card;
import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create.CreateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.create.CreateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.update.UpdateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.car.get.GetCarResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.create.CreateRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetAllRentalsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.update.UpdateRentalResponse;
import bootcamps.turkcell.rentacar.business.rules.RentalBusinessRules;
import bootcamps.turkcell.rentacar.business.services.CarService;
import bootcamps.turkcell.rentacar.business.services.InvoiceService;
import bootcamps.turkcell.rentacar.business.services.PaymentService;
import bootcamps.turkcell.rentacar.business.services.RentalService;
import bootcamps.turkcell.rentacar.common.constants.Values;
import bootcamps.turkcell.rentacar.common.utilities.Calculation;
import bootcamps.turkcell.rentacar.common.utilities.Conversion;
import bootcamps.turkcell.rentacar.common.utilities.Mathematics;
import bootcamps.turkcell.rentacar.domain.entities.Rental;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository repository;
    private final RentalBusinessRules rules;
    private final ModelMapperService mapper;
    private final CarService carService;
    private final InvoiceService invoiceService;
    private final PaymentService paymentService;

    @Override
    public List<GetAllRentalsResponse> getAll() {
        List<Rental> rentals = repository.findAll();
        return rentals.stream().map(rental -> mapper.forResponse().map(rental, GetAllRentalsResponse.class)).toList();
    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(rental, GetRentalResponse.class);
    }

    @Override
    public GetRentalResponse finishRental(int carId) {
        rules.carCannotBeFinishedWhenNotRented(carId);
        Rental rental = repository.findByCarIdAndEndDateNull(carId);
        rental.setEndDate(LocalDate.now());
        repository.save(rental);
        carService.changeState(carId, CarState.AVAILABLE);
        return mapper.forResponse().map(rental, GetRentalResponse.class);
    }

    @Override
    public CreateRentalResponse create(CreateRentalRequest rentalRequest) {
        rules.carCannotBeRentedWhenRented(rentalRequest.getCarId());
        rules.carCannotBeRentedWhenMaintenance(rentalRequest.getCarId());
        rules.carCannotBeRentedWhenNotAvailable(rentalRequest.getCarId());

        Rental rental = mapper.forRequest().map(rentalRequest, Rental.class);
        String datePattern = "d/M/yyyy";
        LocalDate startDate = Conversion.date(rentalRequest.getStartDate(), datePattern);
        LocalDate endDate = Conversion.date(rentalRequest.getEndDate(), datePattern);

        rental.setId(0);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);

        carService.changeState(rental.getCar().getId(), CarState.RENTED);

        createInvoiceRequest(rentalRequest, rental);

        repository.save(rental);

        return mapper.forResponse().map(rental, CreateRentalResponse.class);
    }

    @Override
    public UpdateRentalResponse update(int id, UpdateRentalRequest rentalRequest) {
        rules.idCannotBeProcessedWhenNotExists(id, repository);

        Rental rental = mapper.forRequest().map(rentalRequest, Rental.class);
        rental.setId(id);
        repository.save(rental);
        return mapper.forResponse().map(rental, UpdateRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.idCannotBeProcessedWhenNotExists(id, repository);

        int carId = repository.findById(id).orElseThrow().getCar().getId();
        carService.changeState(carId, CarState.AVAILABLE);
        repository.deleteById(id);
    }

    private void createInvoiceRequest(CreateRentalRequest rentalRequest, Rental rental) {
        GetCarResponse carResponse = carService.getById(rentalRequest.getCarId());
        double dailyRental = carService.getById(rentalRequest.getCarId()).getDailyRental();
        double rentalPrice = calculateRentalPrice(Calculation.daysBetween(rental.getStartDate(), rental.getEndDate()), dailyRental, Values.TaxRate.VAT);

        pay(rentalPrice);

        invoiceService.create(new CreateInvoiceRequest(
                carResponse.getBrandName(),
                carResponse.getModelName(),
                carResponse.getModelYear(),
                carResponse.getLicensePlate(),
                rental.getStartDate(),
                rental.getEndDate(),
                carResponse.getDailyRental(),
                rentalPrice));
    }

    private void pay(double rentalPrice) {
        paymentService.pay(new Card(), rentalPrice);
    }

    private double calculateRentalPrice(int numberOfDaysRented, double dailyPrice, double taxRate) {
        return Mathematics.addPercentOf(dailyPrice, taxRate) * numberOfDaysRented;
    }
}
