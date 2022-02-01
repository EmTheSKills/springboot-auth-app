package ca.ulaval.glo3202.authapp.application.assemblers;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserPasswordCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {
    public UserCreationDto toUserCreationDto(UserDomain user) {
        return new UserCreationDto(user.getStringUserId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getCreation());
    }
    public UserPasswordCreationDto toUserPasswordCreationDto(UserDomain user) {
        return new UserPasswordCreationDto(user.getStringPassword());
    }
}
