package ca.ulaval.glo3202.authapp.application.exception;

public class UsernameAlreadyUseException extends DomainException {
    private static final String ERROR_CODE = "ALREADY_USED_USERNAME";
    private static final String MESSAGE = "The username you try to register with your account is already taken";

    public UsernameAlreadyUseException() {
        super(ERROR_CODE, MESSAGE);
    }
}
