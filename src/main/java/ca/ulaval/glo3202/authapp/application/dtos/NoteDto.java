package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="notes")
public class NoteDto {

    public NoteDto(){}

    public NoteDto(String id, String title, String body,  LocalDateTime creation) {
        this.id = id;
        this.title = title;
        this.tags = new ArrayList<>();
        this.body = body;
        this. creation = creation;
    }

    @Id
    public String id;

    public String title;

    @ManyToOne
    @JoinColumn(name = "owner_username", foreignKey = @ForeignKey(name = "USERNAME_FK"))
    public UserDto owner;

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<TagDto> tags = new ArrayList<>();;

    public String body;

    public LocalDateTime creation;

    public void addTag(TagDto tag) {
        tags.add(tag);
        tag.note = this;
    }

    public void removeTag(TagDto tag) {
        tags.remove(tag);
        tag.note = null;
    }
}
