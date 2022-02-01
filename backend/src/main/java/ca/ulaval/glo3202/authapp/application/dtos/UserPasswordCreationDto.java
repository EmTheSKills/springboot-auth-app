package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EncryptPassword")
public class UserPasswordCreationDto implements Serializable {

    public UserPasswordCreationDto(String password) {
        this.password = password;
    }

    public UserPasswordCreationDto(){}

    @Id
    public String id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    public UserCreationDto user;

    public String password;
}
