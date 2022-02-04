package ca.ulaval.glo3202.authapp.application.exception;

public abstract class DomainException extends RuntimeException{
    public String errorCode;
    public String message;

    protected DomainException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
