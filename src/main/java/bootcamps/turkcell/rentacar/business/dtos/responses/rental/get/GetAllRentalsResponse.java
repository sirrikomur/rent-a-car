package bootcamps.turkcell.rentacar.business.dtos.responses.rental.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRentalsResponse {
    private int id;
    private int carId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}