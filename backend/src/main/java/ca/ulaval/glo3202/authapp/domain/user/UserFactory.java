package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public UserDomain createUser(SignUpDto dto, PasswordEncoder encoder) {
        return new UserDomain(dto.firstName, dto.lastName , dto.username, dto.email, new UserEncryptPassword(encoder.encode(dto.password)));
    }
}
