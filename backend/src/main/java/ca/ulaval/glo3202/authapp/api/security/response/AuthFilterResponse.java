package ca.ulaval.glo3202.authapp.api.security.response;


public abstract class AuthFilterResponse {
    public String errorCode;
    public String message;

    protected AuthFilterResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
