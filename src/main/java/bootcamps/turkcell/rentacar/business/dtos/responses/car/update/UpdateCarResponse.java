package bootcamps.turkcell.rentacar.business.dtos.responses.car.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {
    private int id;
    private int modelId;
    private short modelYear;
    private String licensePlate;
    private double dailyRental;
}
