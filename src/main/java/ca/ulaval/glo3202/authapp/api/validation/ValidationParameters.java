package ca.ulaval.glo3202.authapp.api.validation;

public class ValidationParameters {
    public static final String NAME_REGEX = "^[a-zA-Z \\u0080-\\u9fff\\-\\.\\']*$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_.-])(?=\\S+$).{8,}$";
    public static final String INVALID_NAME_MESSAGE = "The field does not respect naming convention";
    public static final String BLANK_OR_EMPTY_MESSAGE = "The field must not be blank or empty";
    public static final String INVALID_EMAIL_MESSAGE = "The field does not respect email convention pattern";
    public static final String INVALID_PASSWORD_MESSAGE = "The field does not respect password convention pattern (minimum: 1 lowercase, 1 uppercase, 1 digit, 1 special character, min lenght 8)";

}
