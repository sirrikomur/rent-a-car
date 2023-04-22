package bootcamps.turkcell.rentacar.business.dtos.requests.invoice.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {
    private int carId;
    private String carModelName;
    private String carModelBrandName;
    private short carModelYear;
    private String carLicencePlate;
    private double carDailyRental;
}
