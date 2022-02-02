package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@SecondaryTable(name = "password", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class UserCreationDto implements Serializable {

    public UserCreationDto(String id, String firstName, String lastName, String username, String email, LocalDateTime creation, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.creation = creation;
        this.password = password;
    }

    public UserCreationDto(){}

    @Id
    public String id;

    public String firstName;

    public String lastName;

    @Column(unique = true)
    public String username;

    public String email;

    public LocalDateTime creation;

    @Column(name = "password",table = "password")
    public String password;
}
