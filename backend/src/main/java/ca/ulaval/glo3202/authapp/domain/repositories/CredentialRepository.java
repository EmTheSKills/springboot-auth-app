package ca.ulaval.glo3202.authapp.domain.repositories;

import ca.ulaval.glo3202.authapp.application.dtos.CredentialDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<CredentialDto, String> {
}
