package ca.ulaval.glo3202.authapp.application.dtos.assemblers;

import ca.ulaval.glo3202.authapp.application.dtos.CredentialDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {
    public UserDto toUserCreationDto(User user) {
        return new UserDto(user.getUserIdAsAString(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getCreation());
    }

    public CredentialDto toCredentialDto(User user, String hashPassword) {
        return new CredentialDto(user.getUsername(), hashPassword, user.getUserIdAsAString());
    }
}
