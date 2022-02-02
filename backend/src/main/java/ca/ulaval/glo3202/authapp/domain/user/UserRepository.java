package ca.ulaval.glo3202.authapp.domain.user;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserCreationDto, String> {

    @Transactional
    @Query("SELECT user FROM UserCreationDto user where user.username = :username")
    UserCreationDto findUserByUsername(@Param("username") String username);
}
