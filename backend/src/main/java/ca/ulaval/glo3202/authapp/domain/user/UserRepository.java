package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserPasswordCreationDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserPasswordCreationDto, String> {
}
