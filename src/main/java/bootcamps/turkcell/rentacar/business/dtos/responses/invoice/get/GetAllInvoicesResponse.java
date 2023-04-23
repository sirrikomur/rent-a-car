package bootcamps.turkcell.rentacar.business.dtos.responses.invoice.get;

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
public class GetAllInvoicesResponse {
    private int id;
    private String modelName;
    private short modelYear;
    private String brandName;
    private String licencePlate;
    private double dailyRental;
    private LocalDateTime createdDate;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double taxRate;
    private double rentalPrice;
}