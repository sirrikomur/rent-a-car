package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create.CreateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.requests.invoice.update.UpdateInvoiceRequest;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.create.CreateInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetAllInvoicesResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get.GetInvoiceResponse;
import bootcamps.turkcell.rentacar.business.dtos.responses.invoice.update.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(int id);

    CreateInvoiceResponse create(CreateInvoiceRequest invoiceRequest);

    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest invoiceRequest);

    void delete(int id);
}
