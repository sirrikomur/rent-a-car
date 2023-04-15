package bootcamps.turkcell.rentacar.business.dtos.requests.brand.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequest {
    private int id;
    private String name;
}
