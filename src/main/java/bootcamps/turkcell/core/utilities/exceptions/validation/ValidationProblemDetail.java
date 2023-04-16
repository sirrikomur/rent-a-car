package bootcamps.turkcell.core.utilities.exceptions.validation;

import bootcamps.turkcell.core.utilities.exceptions.ProblemDetail;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ValidationProblemDetail extends ProblemDetail {
    private Map<String, String> validationErrors;
}

