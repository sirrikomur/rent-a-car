package bootcamps.turkcell.rentacar.business.dtos.responses.brand.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBrandResponse {
    private int id;
    private String name;
}
