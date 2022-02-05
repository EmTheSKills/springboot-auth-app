package ca.ulaval.glo3202.authapp.application.dtos.assemblers;

import ca.ulaval.glo3202.authapp.application.dtos.CredentialsDto;
import ca.ulaval.glo3202.authapp.application.dtos.NoteCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.TagDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAssembler {
    public UserDto toUserCreationDto(User user) {
        return new UserDto( user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCreation());
    }

    public CredentialsDto toCredentialsDto(User user, String hashPassword) {
        return new CredentialsDto(user.getUsername(), hashPassword);
    }
}
