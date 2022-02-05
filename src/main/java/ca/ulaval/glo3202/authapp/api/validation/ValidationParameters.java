package ca.ulaval.glo3202.authapp.api.validation;

public class ValidationParameters {
    public static final String NAME_REGEX = "^[a-zA-Z \\-\\.\\']*$";
    public static final String INVALID_NAME_MESSAGE = "The field does not respect naming convention";
    public static final String BLANK_OR_EMPTY_MESSAGE = "The field must not be blank or empty";
    public static final String INVALID_EMAIL_MESSAGE = "The field does not respect email convention pattern";
    public static final String INVALID_NUMBER_MESSAGE = "The field must be a number";
}
