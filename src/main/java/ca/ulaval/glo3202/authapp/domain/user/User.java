package ca.ulaval.glo3202.authapp.domain.user;

import java.time.LocalDateTime;

public class User {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final LocalDateTime creation;

    public User(String username, String firstName, String lastName, String email, LocalDateTime creation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.creation = creation;
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
