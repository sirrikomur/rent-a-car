package bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create;

import bootcamps.turkcell.rentacar.domain.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private int carId;
//    private String carModelName;
//    private String carModelBrandName;
//    private short carModelYear;
//    private String carLicencePlate;
//    private double carDailyRental;

    private String rentalStartDate;
    private String rentalEndDate;
}


