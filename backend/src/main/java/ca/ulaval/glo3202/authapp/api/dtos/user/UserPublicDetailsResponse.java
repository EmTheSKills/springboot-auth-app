package ca.ulaval.glo3202.authapp.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPublicDetailsResponse {
    @JsonProperty("id")
    public String id;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("username")
    public String username;
}
