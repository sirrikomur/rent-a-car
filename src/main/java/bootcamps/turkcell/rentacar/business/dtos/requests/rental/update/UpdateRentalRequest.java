package bootcamps.turkcell.rentacar.business.dtos.requests.rental.update;

import bootcamps.turkcell.rentacar.common.constants.Regex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalRequest {
    @NotNull
    private int carId;
    @NotBlank
    @Pattern(regexp = Regex.DATE_FORMAT_DAY_MONTH_YEAR)
    private String startDate;
    @Pattern(regexp = Regex.DATE_FORMAT_DAY_MONTH_YEAR)
    private String endDate;
}
