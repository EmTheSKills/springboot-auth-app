package ca.ulaval.glo3202.authapp.api.exception.badrequest;

import ca.ulaval.glo3202.authapp.api.exception.ApiException;

public class BadRequestApiException extends ApiException {
    public BadRequestApiException(String errorCode, String message) {
        super(errorCode, message);
    }
}
