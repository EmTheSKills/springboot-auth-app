package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class UserCreationDto implements Serializable {

    public UserCreationDto(String id, String firstName, String lastName, String username, String email, LocalDateTime creation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.creation = creation;
    }

    public UserCreationDto(){}

    @Id
    public String id;

    public String firstName;

    public String lastName;

    public String username;

    public String email;

    public LocalDateTime creation;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    public UserPasswordCreationDto password;
}
