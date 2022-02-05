package ca.ulaval.glo3202.authapp.application.dtos.assemblers;

import ca.ulaval.glo3202.authapp.application.dtos.NoteDto;
import ca.ulaval.glo3202.authapp.application.dtos.TagDto;
import ca.ulaval.glo3202.authapp.domain.note.Note;
import org.springframework.stereotype.Component;


@Component
public class NoteAssembler {
    public NoteDto toNoteDto(Note note) {
        NoteDto noteDto = new NoteDto(note.getId(), note.getTitle(), note.getBody(), note.getCreation());
        for (String tag: note.getTags()) {
            noteDto.addTag(new TagDto(tag));
        }
        return noteDto;
    }
}
