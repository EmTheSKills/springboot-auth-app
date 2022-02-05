package ca.ulaval.glo3202.authapp.application;

import ca.ulaval.glo3202.authapp.application.dtos.NoteCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.TagDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.application.dtos.NoteDto;
import ca.ulaval.glo3202.authapp.application.dtos.assemblers.NoteAssembler;
import ca.ulaval.glo3202.authapp.application.exception.InvalidNoteIdException;
import ca.ulaval.glo3202.authapp.application.exception.UserNotFoundException;
import ca.ulaval.glo3202.authapp.domain.note.Note;
import ca.ulaval.glo3202.authapp.domain.note.NoteFactory;
import ca.ulaval.glo3202.authapp.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private NoteFactory noteFactory;

    @Autowired
    private NoteAssembler noteAssembler;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.findById(username).orElseThrow(UserNotFoundException::new);
    }

    public List<UserDto> listUser() {
        return userRepository.findAll();
    }

    public NoteDto createNote(NoteCreationDto noteCreationDto, String username) {
        Note note = noteFactory.createNote(noteCreationDto);
        NoteDto noteDto = noteAssembler.toNoteDto(note);
        UserDto userDto = getUserByUsername(username);
        userDto.addNote(noteDto);
        userRepository.save(userDto);

        return noteDto;
    }

    public UserDto deleteNote(String username, String id) {
        UserDto userDto = getUserByUsername(username);
        int initialSize = userDto.notes.size();
        userDto.notes.removeIf(noteDto -> noteDto.id.equals(id));
        if (initialSize == userDto.notes.size()) {
            throw new InvalidNoteIdException();
        }
        return userRepository.save(userDto);
    }
/*
    public UserDto updateNote(NoteCreationDto noteCreationDto, String username, String id) {
        Note note = noteFactory.createNote(noteCreationDto);
        NoteDto noteDto = noteAssembler.toNoteDto(note);
        noteDto.id = id;
        UserDto userDto = deleteNote(username, id);
        userDto.notes.add(noteDto);
        return userRepository.save(userDto);
    }
 */
}
