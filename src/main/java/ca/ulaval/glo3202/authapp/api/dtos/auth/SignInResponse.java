package ca.ulaval.glo3202.authapp.api.dtos.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SignInResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    @JsonProperty("username")
    public String username;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;
}
