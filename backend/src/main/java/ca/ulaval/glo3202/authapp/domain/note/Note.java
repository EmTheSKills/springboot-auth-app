package ca.ulaval.glo3202.authapp.domain.note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Note {

    private final NoteId id;
    private String title;
    private List<Tags> tags;
    private String body;
    private LocalDateTime creation;

    public Note(NoteId id, String title, List<Tags> tags, String body, LocalDateTime creation) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.body = body;
        this.creation = creation;
    }

    public String getId() {
        return id.getNoteIdAsString();
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        List<String> stringTags = new ArrayList<>();
        for (Tags tag: tags) {
            stringTags.add(tag.name());
        }
        return stringTags;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreation() {
        return creation;
    }
}
