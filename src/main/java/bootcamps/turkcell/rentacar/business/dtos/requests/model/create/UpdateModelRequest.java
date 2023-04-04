package bootcamps.turkcell.rentacar.business.dtos.requests.model.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {
    private int id;
    private String name;
    private int brandId;
}
