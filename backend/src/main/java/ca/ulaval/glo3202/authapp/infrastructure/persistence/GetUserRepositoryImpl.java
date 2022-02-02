package ca.ulaval.glo3202.authapp.infrastructure.persistence;

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

