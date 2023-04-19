package bootcamps.turkcell.rentacar.business.dtos.requests.car.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    @NotNull
    private int modelId;

    @NotNull
    @Min(1885)
    @Max(2023)
    private short modelYear;

    @NotBlank
    //@Size(min = 7, max = 8)
    @Pattern(regexp = "^(?:[A-Z]{2}\\s?\\d{3}\\s?[A-Z]{1,2}|\\d{2}\\s?[A-Z]{1,3}\\s?\\d{2,4})$")
    private String licensePlate;

    @NotNull
    @PositiveOrZero
    private double dailyRental;
}
