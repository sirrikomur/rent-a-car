package bootcamps.turkcell.rentacar.business.dtos.requests.car.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    @NotNull
    private int modelId;

    @NotNull
    @Min(1885)
    @Max(2023)
    private short modelYear;

    @NotBlank
    @Size(min = 7, max = 8)
    private String licensePlate;

    @NotNull
    @PositiveOrZero
    private double dailyRental;
}
