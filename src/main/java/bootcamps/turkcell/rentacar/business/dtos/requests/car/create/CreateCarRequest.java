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

    @NotEmpty
    @Min(1885)
    @Max(2023)
    private short modelYear;

    @NotEmpty
    @Size(min = 7, max = 8)
    private String licensePlate;

    @NotEmpty
    @PositiveOrZero
    private double dailyRental;
}
