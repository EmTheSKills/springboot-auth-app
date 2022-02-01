package ca.ulaval.glo3202.authapp.infrastructure.persistence;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends UserRepository {
}
