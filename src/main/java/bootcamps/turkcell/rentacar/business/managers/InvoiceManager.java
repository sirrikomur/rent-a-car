package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.utilities.mappers.services.ModelMapperService;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create.CreateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.update.UpdateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.create.CreateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetAllInvoicesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.update.UpdateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.services.InvoiceService;
import bootcamps.turkcell.rentacar.common.constants.Values;
import bootcamps.turkcell.rentacar.domain.entities.Invoice;
import bootcamps.turkcell.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapperService mapper;

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
}
