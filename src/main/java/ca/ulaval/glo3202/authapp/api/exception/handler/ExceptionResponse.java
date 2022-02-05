package ca.ulaval.glo3202.authapp.api.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Map;

public class ExceptionResponse {
    public final String errorCode;
    public final String message;

    @JsonInclude(NON_NULL)
    public Map<String, String> fields;

    public ExceptionResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ExceptionResponse(String errorCode, String message, Map<String, String> fields) {
        this.errorCode = errorCode;
        this.message = message;
        this.fields = fields;
    }
}