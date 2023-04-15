package bootcamps.turkcell.rentacar.business.dtos.requests.car.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int modelId;
    private short modelYear;
    private String licensePlate;
    private double dailyRental;
}
