package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.dtos.assemblers.UserDtoAssembler;
import ca.ulaval.glo3202.authapp.api.dtos.user.NoteRequest;
import ca.ulaval.glo3202.authapp.api.dtos.user.NoteResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserFullDetailsResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserPublicDetailsResponse;
import ca.ulaval.glo3202.authapp.api.validation.UserResourceValidator;
import ca.ulaval.glo3202.authapp.application.UserService;
import ca.ulaval.glo3202.authapp.application.dtos.NoteCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.NoteDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserResourceValidator userResourceValidator;

    @Autowired
    private UserDtoAssembler userDtoAssembler;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @GetMapping()
    public ResponseEntity<List<UserPublicDetailsResponse>> getUsers() {
        List<UserDto> usersDtos = userService.listUser();
        List<UserPublicDetailsResponse> response = userDtoAssembler.toUserPublicDetailsResponse(usersDtos);
        return ResponseEntity.ok(response);
    }

     */

    @GetMapping("/{username}")
    public ResponseEntity<UserFullDetailsResponse> getUserContent(@PathVariable String username, Principal principal) {
        userResourceValidator.usernameMatchPrincipal(username, principal);
        UserDto userDto = userService.getUserByUsername(username);
        UserFullDetailsResponse response = userDtoAssembler.toUserFullDetailsResponse(userDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{username}/note")
    public ResponseEntity<NoteResponse> addNote(@Valid @RequestBody NoteRequest noteRequest, @PathVariable String username, Principal principal) {
        userResourceValidator.usernameMatchPrincipal(username, principal);
        NoteCreationDto noteCreationDto = userDtoAssembler.toNoteCreationDto(noteRequest);
        NoteDto noteDto = userService.createNote(noteCreationDto, username);
        NoteResponse response = userDtoAssembler.toNoteResponse(noteDto, true);

        return ResponseEntity.status(CREATED).body(response);
    }

    @DeleteMapping("/{username}/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String username, @PathVariable String id, Principal principal) {
        userResourceValidator.usernameMatchPrincipal(username, principal);
        UserDto userDto = userService.deleteNote(username, id);
        UserFullDetailsResponse response = userDtoAssembler.toUserFullDetailsResponse(userDto);
        return ResponseEntity.ok(response);
    }
/*
    @PutMapping("/{username}/note/{id}")
    public ResponseEntity<UserFullDetailsResponse> updateNote(@Valid @RequestBody NoteRequest noteRequest, @PathVariable String username,
                                                   @PathVariable String id, Principal principal) {
        userResourceValidator.usernameMatchPrincipal(username, principal);
        NoteCreationDto noteCreationDto = userDtoAssembler.toNoteCreationDto(noteRequest);
        UserDto userDto = userService.updateNote(noteCreationDto, username, id);
        UserFullDetailsResponse response = userDtoAssembler.toUserFullDetailsResponse(userDto);

        return ResponseEntity.ok(response);
    }

 */
}
