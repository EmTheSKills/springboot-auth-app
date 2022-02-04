package ca.ulaval.glo3202.authapp.api.exception.unauthorized;

public class InvalidCredentialsException extends UnauthorizedApiException {
    private static final String ERROR_CODE = "INVALID_CREDENTIALS";
    private static final String MESSAGE = "The entered credentials are invalid";

    public InvalidCredentialsException() {
        super(ERROR_CODE, MESSAGE);
    }
}
