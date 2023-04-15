package bootcamps.turkcell.rentacar.business.dtos.responses.car.get;

import bootcamps.turkcell.rentacar.domain.enums.CarState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {
    private int id;
    private int modelId;
    private short modelYear;
    private String licensePlate;
    private CarState carState;
    private double dailyRental;
}
