package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.create.CreateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.rental.update.UpdateRentalRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.create.CreateRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetAllRentalsResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.get.GetRentalResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.rental.update.UpdateRentalResponse;
import bootcamps.turkcell.rentacar.business.rules.RentalBusinessRules;
import bootcamps.turkcell.rentacar.business.services.CarService;
import bootcamps.turkcell.rentacar.business.services.RentalService;
import bootcamps.turkcell.rentacar.domain.entities.Rental;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository repository;
    private final RentalBusinessRules rules;
    private final ModelMapperService mapper;
    private final CarService carService;

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
        rental.setEndDate(LocalDateTime.now());
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
        rental.setId(0);
        rental.setStartDate(LocalDateTime.now());
        carService.changeState(rental.getCar().getId(), CarState.RENTED);
        repository.save(rental);
        return mapper.forResponse().map(rental, CreateRentalResponse.class);
    }

    @Override
    public UpdateRentalResponse update(int id, UpdateRentalRequest rentalRequest) {
        Rental rental = mapper.forRequest().map(rentalRequest, Rental.class);
        rental.setId(id);
        repository.save(rental);
        return mapper.forResponse().map(rental, UpdateRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        int carId = repository.findById(id).orElseThrow().getCar().getId();
        carService.changeState(carId, CarState.AVAILABLE);
        repository.deleteById(id);
    }
}
