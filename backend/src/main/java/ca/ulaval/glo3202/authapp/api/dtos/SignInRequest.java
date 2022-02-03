package ca.ulaval.glo3202.authapp.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SignInRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    public SignInRequest(){};

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;
}