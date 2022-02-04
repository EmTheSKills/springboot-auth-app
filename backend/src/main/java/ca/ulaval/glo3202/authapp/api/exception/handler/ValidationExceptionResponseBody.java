package ca.ulaval.glo3202.authapp.api.exception.handler;

import java.util.Map;

public class ValidationExceptionResponseBody extends ExceptionResponseBody {
    public final Map<String, String> fields;

    public ValidationExceptionResponseBody(String errorCode, String message, Map<String, String> fields) {
        super(errorCode, message);
        this.fields = fields;
    }
}