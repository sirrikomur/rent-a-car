package bootcamps.turkcell.core.configurations.exceptions;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.core.utilities.exceptions.business.BusinessProblemDetail;
import bootcamps.turkcell.core.utilities.exceptions.validation.ValidationProblemDetail;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public BusinessProblemDetail handleBusinessException(BusinessException exception) {
        BusinessProblemDetail problemDetail = new BusinessProblemDetail();
        problemDetail.setType(exception.getClass().getSimpleName());
        problemDetail.setMessage(exception.getMessage());
        problemDetail.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        return problemDetail;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetail handleValidationException(MethodArgumentNotValidException exception) {
        ValidationProblemDetail problemDetail = new ValidationProblemDetail();
        problemDetail.setType(exception.getClass().getSimpleName());
        problemDetail.setMessage("Validation failed.");
        problemDetail.setValidationErrors(new HashMap<>());
        problemDetail.setCode(HttpStatus.BAD_REQUEST.value());

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            problemDetail.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return problemDetail;
    }

}
