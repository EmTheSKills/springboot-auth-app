package ca.ulaval.glo3202.authapp.application.exception;

public class UserNotFoundException extends DomainException {
    private static final String ERROR_CODE = "USER_NOT_FOUND";
    private static final String MESSAGE = "The user you try to search doesn't existe";

    public UserNotFoundException() {
        super(ERROR_CODE, MESSAGE);
    }
}