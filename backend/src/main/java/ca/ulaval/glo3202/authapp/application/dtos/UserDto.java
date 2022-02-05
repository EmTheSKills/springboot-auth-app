package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//@SecondaryTable(name = "password", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))

@Entity
@Table(name = "user")
public class UserDto implements Serializable {

    public UserDto(String username, String firstName, String lastName, String email, LocalDateTime creation) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.creation = creation;
        this.notes =  new ArrayList<>();
    }

    public UserDto(){}

    @Id
    public String username;

    public String firstName;

    public String lastName;

    public String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<NoteDto> notes;

    public LocalDateTime creation;

    public void addNote(NoteDto note) {
        notes.add(note);
        note.owner = this;
    }

    public void removeNote(NoteDto note) {
        notes.remove(note);
        note.owner = null;
    }
}
