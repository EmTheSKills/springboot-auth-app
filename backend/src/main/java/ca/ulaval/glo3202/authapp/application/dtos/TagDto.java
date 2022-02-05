package ca.ulaval.glo3202.authapp.application.dtos;

import ca.ulaval.glo3202.authapp.application.dtos.NoteDto;

import javax.persistence.*;


@Entity
@Table(name = "tags")
public class TagDto {

    public TagDto(){}

    public TagDto(String tag) {
        this.tag = tag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String tag;

    @ManyToOne
    @JoinColumn(name = "note_id", foreignKey = @ForeignKey(name = "NOTE_ID_FK"))
    public NoteDto note;
}
