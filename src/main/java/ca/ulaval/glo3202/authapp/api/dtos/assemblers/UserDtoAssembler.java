package ca.ulaval.glo3202.authapp.api.dtos.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.user.NoteRequest;
import ca.ulaval.glo3202.authapp.api.dtos.user.NoteResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserFullDetailsResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserPublicDetailsResponse;
import ca.ulaval.glo3202.authapp.application.dtos.NoteCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.NoteDto;
import ca.ulaval.glo3202.authapp.application.dtos.TagDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoAssembler {
    public UserFullDetailsResponse toUserFullDetailsResponse(UserDto dto) {
        UserFullDetailsResponse response = new UserFullDetailsResponse();
        response.username = dto.username;
        response.firstName = dto.firstName;
        response.lastName = dto.lastName;
        response.email = dto.email;
        List<NoteResponse> notes = new ArrayList<>();
        for (NoteDto noteDto: dto.notes) {
            notes.add(toNoteResponse(noteDto, false));
        }
        response.notes = notes;
        response.creation = dto.creation;

        return response;
    }

    public List<UserPublicDetailsResponse> toUserPublicDetailsResponse(List<UserDto> dtos) {
        List<UserPublicDetailsResponse> response = new ArrayList<>();
        for (UserDto dto: dtos) {
            UserPublicDetailsResponse content = new UserPublicDetailsResponse();
            content.username = dto.username;
            content.firstName = dto.firstName;
            content.lastName = dto.lastName;
            content.email = dto.email;

            response.add(content);
        }
        return response;
    }

    public NoteCreationDto toNoteCreationDto(NoteRequest note) {
        NoteCreationDto dto = new NoteCreationDto();
        dto.title= note.title;
        dto.tags = note.tags;
        dto.body = note.body;
        return dto;
    }

    public NoteResponse toNoteResponse(NoteDto noteDto, boolean withOwner) {
        List<String> tags = extractTagDtoToTag(noteDto.tags);
        NoteResponse response = new NoteResponse();
        response.id = noteDto.id;
        if (withOwner) {
            response.owner = noteDto.owner.username;
        }
        response.title = noteDto.title;
        response.tags = tags;
        response.body = noteDto.body;
        return response;
    }

    private List<String> extractTagDtoToTag(List<TagDto> tagsDto) {
        List<String> tags = new ArrayList<>();
        for (TagDto tag: tagsDto) {
            tags.add(tag.tag);
        }
        return tags;
    }
}
