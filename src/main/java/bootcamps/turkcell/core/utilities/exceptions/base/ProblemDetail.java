package bootcamps.turkcell.core.utilities.exceptions.base;

import bootcamps.turkcell.rentacar.common.constants.ExceptionDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProblemDetail {
    private LocalDateTime timestamp;
    private String type;
    private Object message;
    private int code;

    public ProblemDetail(String type, Object message, int code) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
        this.code = code;
    }
}
