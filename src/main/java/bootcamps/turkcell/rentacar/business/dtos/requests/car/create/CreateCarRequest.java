package bootcamps.turkcell.rentacar.business.dtos.requests.car.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelId;
    private short modelYear;
    private String licensePlate;
    private double dailyRental;
}