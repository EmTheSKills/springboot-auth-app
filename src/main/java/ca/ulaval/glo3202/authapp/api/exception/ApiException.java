package ca.ulaval.glo3202.authapp.api.exception;

public abstract class ApiException extends RuntimeException {
    public String errorCode;
    public String message;

    protected ApiException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
