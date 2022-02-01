package ca.ulaval.glo3202.authapp.infrastructure.persistence;

import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserPasswordCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.GetUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/*
@Repository
@Transactional
public class GetUserRepositoryImpl implements GetUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserPasswordCreationDto findByUsername(String username) {
        UserPasswordCreationDto response;
        try {
            response = (UserPasswordCreationDto) entityManager.createQuery("SELECT u FROM encrypt_pa u WHERE u.username = :key")
                    .setParameter("key", username).getSingleResult();
            return response;
        } catch (NoResultException exception) {
            response = null;
        }

    }
}
*/

