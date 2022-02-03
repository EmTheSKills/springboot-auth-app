package ca.ulaval.glo3202.authapp.domain.user;

import java.time.Clock;
import java.time.LocalDateTime;

public class UserDomain {

    private final UserId id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final LocalDateTime creation;


    public UserDomain(String firstName, String lastName, String username, String email) {
        this.id = new UserId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.creation = LocalDateTime.now(Clock.systemDefaultZone());
    }

    public UserId getUserId() {
        return id;
    }

    public String getStringUserId() {
        return id.getId();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreation() {
        return creation;
    }
}
