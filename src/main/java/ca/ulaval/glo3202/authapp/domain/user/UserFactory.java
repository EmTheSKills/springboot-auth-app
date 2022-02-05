package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

@Component
public class UserFactory {

    public User createUser(SignUpDto dto) {
        LocalDateTime creation = LocalDateTime.now(Clock.systemDefaultZone());
        return new User(dto.username, dto.firstName, dto.lastName , dto.email, creation);
    }
}
