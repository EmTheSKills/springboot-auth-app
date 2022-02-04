package ca.ulaval.glo3202.authapp.api.exception.unauthorized;

import ca.ulaval.glo3202.authapp.api.exception.ApiException;

public class UnauthorizedApiException extends ApiException {
    protected UnauthorizedApiException(String errorCode, String message) {
        super(errorCode, message);
    }
}
