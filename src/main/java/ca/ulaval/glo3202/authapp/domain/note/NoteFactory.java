package ca.ulaval.glo3202.authapp.domain.note;

import ca.ulaval.glo3202.authapp.application.dtos.NoteCreationDto;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class NoteFactory {
    public Note createNote(NoteCreationDto dto) {
        NoteId id = new NoteId();
        LocalDateTime creation = LocalDateTime.now(Clock.systemDefaultZone());
        List<Tags> tags = new ArrayList<>();
        for (String tag: dto.tags) {
            tags.add(Tags.valueOf(tag.toUpperCase(Locale.ROOT)));
        }
        return new Note(id, dto.title, tags, dto.body, creation);
    }
}
