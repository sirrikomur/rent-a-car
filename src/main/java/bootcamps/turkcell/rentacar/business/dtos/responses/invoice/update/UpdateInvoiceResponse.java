package bootcamps.turkcell.rentacar.business.dtos.responses.invoice.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceResponse {
    private int id;
    private int carId;
}
