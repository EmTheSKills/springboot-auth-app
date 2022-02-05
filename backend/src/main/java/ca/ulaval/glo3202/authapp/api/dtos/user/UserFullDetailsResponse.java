package ca.ulaval.glo3202.authapp.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class UserFullDetailsResponse {

    @JsonProperty("username")
    public String username;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("notes")
    public List<NoteResponse> notes;

    @JsonProperty("creation")
    public LocalDateTime creation;
}
