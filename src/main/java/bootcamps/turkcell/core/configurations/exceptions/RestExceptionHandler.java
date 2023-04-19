package bootcamps.turkcell.core.configurations.exceptions;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.core.utilities.exceptions.business.BusinessProblemDetail;
import bootcamps.turkcell.core.utilities.exceptions.validation.ValidationProblemDetail;
import bootcamps.turkcell.rentacar.common.constants.ExceptionTypes;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public BusinessProblemDetail handleBusinessException(BusinessException exception) {
        return new BusinessProblemDetail(ExceptionTypes.BUSINESS_EXCEPTION, exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetail handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ValidationProblemDetail(ExceptionTypes.VALIDATION_EXCEPTION, validationErrors, HttpStatus.BAD_REQUEST.value());
    }
}
