package bootcamps.turkcell.rentacar.business.dtos.responses.model.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelResponse {
    private int id;
    private String name;
    private int brandId;
}
