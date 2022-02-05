package ca.ulaval.glo3202.authapp.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPublicDetailsResponse {
    @JsonProperty("username")
    public String username;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;

}
