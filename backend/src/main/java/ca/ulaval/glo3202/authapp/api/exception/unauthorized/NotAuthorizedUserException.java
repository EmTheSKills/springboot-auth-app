package ca.ulaval.glo3202.authapp.api.exception.unauthorized;

public class NotAuthorizedUserException extends UnauthorizedApiException {
    private static final String ERROR_CODE = "NOT_AUTHORIZED";
    private static final String MESSAGE = "The current user is not authorized to see the resource";

    public NotAuthorizedUserException() {
        super(ERROR_CODE, MESSAGE);
    }
}

