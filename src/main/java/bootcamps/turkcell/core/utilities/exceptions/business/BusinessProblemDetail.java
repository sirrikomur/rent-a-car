package bootcamps.turkcell.core.utilities.exceptions.business;


import bootcamps.turkcell.core.utilities.exceptions.base.ProblemDetail;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BusinessProblemDetail extends ProblemDetail {

    public BusinessProblemDetail(String type, Object message, int code) {
        super(type, message, code);
    }
}


