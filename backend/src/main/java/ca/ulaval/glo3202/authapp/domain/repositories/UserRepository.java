package ca.ulaval.glo3202.authapp.domain.repositories;

import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDto, String> {
    @Query("SELECT user FROM UserDto user WHERE user.username=:username")
    UserDto findUserByUsername(@Param("username") String username);
}