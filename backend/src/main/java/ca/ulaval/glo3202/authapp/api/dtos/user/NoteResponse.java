package ca.ulaval.glo3202.authapp.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class NoteResponse {

    @JsonProperty("id")
    public String id;

    @JsonInclude(NON_NULL)
    @JsonProperty("owner")
    public String owner;

    @JsonProperty("title")
    public String title;

    @JsonProperty("tags")
    public List<String> tags;

    @JsonProperty("body")
    public String body;

}
