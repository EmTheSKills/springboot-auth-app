package ca.ulaval.glo3202.authapp.api.security.response;


public class DisabledAccountResponse extends AuthFilterResponse {
    private static final String ERROR_CODE = "DISABLED_ACCOUNT EP";
    private static final String MESSAGE = "The account has been disabled";

    public DisabledAccountResponse() {
        super(ERROR_CODE, MESSAGE);
    }
}
