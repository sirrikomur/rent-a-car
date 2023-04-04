package bootcamps.turkcell.rentacar.business.dtos.responses.brand.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandResponse {
    private int id;
    private String name;
}
