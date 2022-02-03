package ca.ulaval.glo3202.authapp.application.assemblers;

import ca.ulaval.glo3202.authapp.application.dtos.CredentialDto;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {
    public UserCreationDto toUserCreationDto(UserDomain user) {
        return new UserCreationDto(user.getStringUserId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getCreation());
    }

    public CredentialDto toCredentialDto(UserDomain user, String hashPassword) {
        return new CredentialDto(user.getUsername(), hashPassword, user.getStringUserId());
    }
}
