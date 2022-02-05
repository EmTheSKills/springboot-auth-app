package ca.ulaval.glo3202.authapp.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class NoteRequest implements Serializable {

    @NotBlank
    @JsonProperty("title")
    public String title;

    @JsonProperty("tags")
    public List<String> tags;

    @JsonProperty("body")
    public String body;
}
