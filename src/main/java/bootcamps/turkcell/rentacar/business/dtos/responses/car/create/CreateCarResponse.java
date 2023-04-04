package bootcamps.turkcell.rentacar.business.dtos.responses.car.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarResponse {
    private int id;
    private short modelYear;
    private String licensePlate;
    private double dailyRental;
    private int modelId;
}
