package ca.ulaval.glo3202.authapp.api.exception.handler;

import ca.ulaval.glo3202.authapp.application.exception.UsernameAlreadyUseException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class ServiceExceptionHandler {
    @ExceptionHandler(UsernameAlreadyUseException.class)
    public ResponseEntity<ExceptionResponse> handleConflitExceptions(UsernameAlreadyUseException e) {
        ExceptionResponse response = new ExceptionResponse(e.errorCode, e.message);
        return ResponseEntity.status(CONFLICT).body(response);
    }
}
