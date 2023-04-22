package bootcamps.turkcell.rentacar.business.dtos.responses.invoice.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceResponse {
    private int id;
    private int carId;
}




