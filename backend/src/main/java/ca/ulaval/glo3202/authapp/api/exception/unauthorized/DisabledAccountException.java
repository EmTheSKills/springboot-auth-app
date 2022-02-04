package ca.ulaval.glo3202.authapp.api.exception.unauthorized;

public class DisabledAccountException extends UnauthorizedApiException {
    private static final String ERROR_CODE = "DISABLED_ACCOUNT";
    private static final String MESSAGE = "The account has been disabled";

    public DisabledAccountException() {
        super(ERROR_CODE, MESSAGE);
    }
}
