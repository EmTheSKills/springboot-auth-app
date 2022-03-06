package ca.ulaval.glo3202.authapp.api.dtos.auth;

import static ca.ulaval.glo3202.authapp.api.validation.ValidationParameters.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


public class SignUpRequest implements Serializable {

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @Pattern(regexp = NAME_REGEX, message = INVALID_NAME_MESSAGE)
    @JsonProperty("firstName")
    public String firstName;

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @Pattern(regexp = NAME_REGEX, message = INVALID_NAME_MESSAGE)
    @JsonProperty("lastName")
    public String lastName;

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @JsonProperty("username")
    public String username;

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @Email(message = INVALID_EMAIL_MESSAGE)
    @JsonProperty("email")
    public String email;

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @Pattern(regexp = PASSWORD_REGEX, message = INVALID_PASSWORD_MESSAGE)
    @JsonProperty("password")
    public String password;
}
