package ca.ulaval.glo3202.authapp.api.exception.handler;


import ca.ulaval.glo3202.authapp.api.exception.badrequest.BadRequestApiException;
import ca.ulaval.glo3202.authapp.api.exception.unauthorized.UnauthorizedApiException;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.SortedMap;
import java.util.TreeMap;

@ControllerAdvice
public class ApiExceptionHandler {
    private static final String INVALID_FIELDS_ERROR_CODE = "INVALID_FIELDS";
    private static final String INVALID_FIELDS_ERROR_MESSAGE = "Some fields are missing or invalid";


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationErrors(MethodArgumentNotValidException e) {
        SortedMap<String, String> errors = new TreeMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ExceptionResponse response = new ExceptionResponse(INVALID_FIELDS_ERROR_CODE, INVALID_FIELDS_ERROR_MESSAGE, errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UnauthorizedApiException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestExceptions(UnauthorizedApiException e) {
        ExceptionResponse response = new ExceptionResponse(e.errorCode, e.message);
        return ResponseEntity.status(UNAUTHORIZED).body(response);
    }


    @ExceptionHandler(BadRequestApiException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestExceptions(BadRequestApiException e) {
        ExceptionResponse response = new ExceptionResponse(e.errorCode, e.message);
        return ResponseEntity.badRequest().body(response);
    }
/*
    @ExceptionHandler(NotFoundApplicationException.class)
    public ResponseEntity<Void> handleNotFoundExceptions(NotFoundApplicationException e) {
        return ResponseEntity.notFound().build();
    }

 */

}
