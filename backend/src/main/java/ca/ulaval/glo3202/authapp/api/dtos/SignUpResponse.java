package ca.ulaval.glo3202.authapp.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpResponse {
    @JsonProperty("id")
    public String id;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("username")
    public String username;

    @JsonProperty("email")
    public String email;
}