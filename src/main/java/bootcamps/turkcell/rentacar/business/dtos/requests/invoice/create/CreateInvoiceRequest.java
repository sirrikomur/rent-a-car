package bootcamps.turkcell.rentacar.business.dtos.requests.invoice.create;

import bootcamps.turkcell.rentacar.domain.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private String brandName;
    private String modelName;
    private short modelYear;
    private String licencePlate;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double dailyRental;
    private double rentalPrice;
}


