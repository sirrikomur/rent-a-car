package bootcamps.turkcell.rentacar.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String no;
    private String brandName;
    private String modelName;
    private short modelYear;
    private String licencePlate;
    private LocalDateTime createdDate;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private double taxRate;
    private double dailyRental;
    private double rentalPrice;
}
