package bootcamps.turkcell.rentacar.business.dtos.responses.maintenance.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenanceResponse {
    private int id;
    private int carId;
    private String information;
    //private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
