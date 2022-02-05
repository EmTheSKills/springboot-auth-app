package ca.ulaval.glo3202.authapp.api.dtos.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SignUpResponse implements Serializable {

    @JsonProperty("username")
    public String username;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;
}
