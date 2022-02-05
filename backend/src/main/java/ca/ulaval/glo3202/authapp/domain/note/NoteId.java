package ca.ulaval.glo3202.authapp.domain.note;

import java.util.UUID;

public class NoteId {
    private final UUID id;

    public NoteId() {
        this.id = UUID.randomUUID();
    }

    String getNoteIdAsString() {
        return id.toString();
    }
}
