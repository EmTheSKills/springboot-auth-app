package ca.ulaval.glo3202.authapp.domain.repositories;

import ca.ulaval.glo3202.authapp.application.dtos.CredentialsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<CredentialsDto, String> {
}
