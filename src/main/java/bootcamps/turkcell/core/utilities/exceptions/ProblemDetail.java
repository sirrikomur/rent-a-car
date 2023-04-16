package bootcamps.turkcell.core.utilities.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetail {
    private String type;
    private String message;
    private int code;
}
