package bootcamps.turkcell.rentacar.business.dtos.requests.model.update;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {
    @NotNull
    private int brandId;

    @NotEmpty
    private String name;
}
