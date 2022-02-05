package ca.ulaval.glo3202.authapp.api.security.response;


public class InvalidCredentialsResponse extends AuthFilterResponse {
    private static final String ERROR_CODE = "INVALID_CREDENTIALS EP";
    private static final String MESSAGE = "The entered credentials are invalid";

    public InvalidCredentialsResponse() {
        super(ERROR_CODE, MESSAGE);
    }
}
