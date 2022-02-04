package ca.ulaval.glo3202.authapp.api.exception.handler;

public class ExceptionResponseBody {
    public final String errorCode;
    public final String message;

    public ExceptionResponseBody(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
