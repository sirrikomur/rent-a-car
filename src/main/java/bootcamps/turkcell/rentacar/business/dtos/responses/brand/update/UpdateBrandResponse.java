package bootcamps.turkcell.rentacar.business.dtos.responses.brand.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandResponse {
    private int id;
    private String name;
}
