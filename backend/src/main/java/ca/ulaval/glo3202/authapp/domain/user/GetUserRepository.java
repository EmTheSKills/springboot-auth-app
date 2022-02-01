package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;

public interface GetUserRepository {
    UserCreationDto findByUsername(String username);
}
