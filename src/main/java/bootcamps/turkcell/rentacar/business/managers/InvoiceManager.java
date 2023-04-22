package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create.CreateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.update.UpdateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.create.CreateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetAllInvoicesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.update.UpdateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.services.CarService;
import bootcamps.turkcell.rentacar.business.services.InvoiceService;
import bootcamps.turkcell.rentacar.common.constants.Values;
import bootcamps.turkcell.rentacar.common.operations.Mathematics;
import bootcamps.turkcell.rentacar.domain.entities.Invoice;
import bootcamps.turkcell.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapperService mapper;
    private final CarService carService;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();
        return invoices.stream().map(invoice -> mapper.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();
    }

    @Override
    public GetInvoiceResponse getById(int id) {
        Invoice invoice = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(invoice, GetInvoiceResponse.class);
    }

    @Override
    public CreateInvoiceResponse create(CreateInvoiceRequest invoiceRequest) {
        Invoice invoice = mapper.forRequest().map(invoiceRequest, Invoice.class);
        invoice.setId(0);
        invoice.setNo(generateInvoiceNo());
        invoice.setCreatedDate(LocalDateTime.now());
        invoice.setTaxRate(Values.TaxRate.VAT);
        invoice.setRentalStartDate(convertDate(invoiceRequest.getRentalStartDate()));
        invoice.setRentalEndDate(convertDate(invoiceRequest.getRentalEndDate()));
        double dailyRental = carService.getById(invoiceRequest.getCarId()).getDailyRental();
        invoice.setRentalPrice(calculateRentalPrice(calculateNumberOfDaysRented(invoice.getRentalStartDate(), invoice.getRentalEndDate()), dailyRental, invoice.getTaxRate()));
        repository.save(invoice);

        return mapper.forResponse().map(invoice, CreateInvoiceResponse.class);
    }

    @Override
    public UpdateInvoiceResponse update(int id, UpdateInvoiceRequest invoiceRequest) {
        Invoice invoice = mapper.forRequest().map(invoiceRequest, Invoice.class);
        invoice.setId(id);
        repository.save(invoice);
        return mapper.forResponse().map(invoice, UpdateInvoiceResponse.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private String generateInvoiceNo() {
        Random random = new Random();
        return "INV-" + random.nextInt(1000000000);
    }

    private LocalDate convertDate(String input) {
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(input, dateTimePattern);
    }

    private int calculateNumberOfDaysRented(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }

    private double calculateRentalPrice(int numberOfDaysRented, double dailyPrice, double taxRate) {
        return (dailyPrice + Mathematics.percentOf(dailyPrice, taxRate)) * numberOfDaysRented;
    }
}
