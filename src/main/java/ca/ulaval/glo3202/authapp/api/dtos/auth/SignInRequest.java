package ca.ulaval.glo3202.authapp.api.dtos.auth;

import static ca.ulaval.glo3202.authapp.api.validation.ValidationParameters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class SignInRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    public SignInRequest(){};

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @JsonProperty("username")
    public String username;

    @NotBlank(message = BLANK_OR_EMPTY_MESSAGE)
    @JsonProperty("password")
    public String password;
}