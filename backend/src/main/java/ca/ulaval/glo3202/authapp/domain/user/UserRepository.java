package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCreationDto, String> {
}