package ca.ulaval.glo3202.authapp.api.security.response;


public class ExpiredTokenResponse extends AuthFilterResponse{
    private static final String ERROR_CODE = "EXPIRED_TOKEN FT";
    private static final String MESSAGE = "The current session token is expired, please login again";

    public ExpiredTokenResponse() {
        super(ERROR_CODE, MESSAGE);
    }
}
