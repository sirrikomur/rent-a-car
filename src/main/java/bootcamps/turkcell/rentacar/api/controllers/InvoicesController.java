package bootcamps.turkcell.rentacar.api.controllers;

import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create.CreateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.update.UpdateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.create.CreateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetAllInvoicesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.update.UpdateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.services.InvoiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService service;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreateInvoiceResponse create(@Valid @RequestBody CreateInvoiceRequest invoiceRequest) {
        return service.create(invoiceRequest);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable int id, @Valid @RequestBody UpdateInvoiceRequest invoiceRequest) {
        return service.update(id, invoiceRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
