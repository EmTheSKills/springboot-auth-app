package ca.ulaval.glo3202.authapp.api.security.response;


public class UnauthorizedResponse extends AuthFilterResponse{
    private static final String ERROR_CODE = "NOT_AUTHORIZED";
    private static final String MESSAGE = "The current user is not authorized to see the resource";

    public UnauthorizedResponse() {
        super(ERROR_CODE, MESSAGE);
    }
}
