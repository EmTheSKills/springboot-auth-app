package ca.ulaval.glo3202.authapp.domain.user;

import java.util.UUID;

public class UserId {

    private final UUID id;

    public UserId() {
        id = UUID.randomUUID();
    }

    public String getIdAsAString() {
        return id.toString();
    }
}
