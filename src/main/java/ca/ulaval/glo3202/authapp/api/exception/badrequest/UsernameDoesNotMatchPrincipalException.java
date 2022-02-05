package ca.ulaval.glo3202.authapp.api.exception.badrequest;

public class UsernameDoesNotMatchPrincipalException extends BadRequestApiException {
    private static final String ERROR_CODE = "USER_NOT_AUTHORIZED";
    private static final String MESSAGE = "The resource you want to access doesn't match your credentials";

    public UsernameDoesNotMatchPrincipalException() {
        super(ERROR_CODE, MESSAGE);
    }
}
