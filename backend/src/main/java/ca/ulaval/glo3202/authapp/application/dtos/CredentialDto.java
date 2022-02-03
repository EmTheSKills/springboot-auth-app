package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;

@Entity
@Table(name = "credential")
public class CredentialDto {

    public CredentialDto(String username, String password, String userId){
        this.username = username;
        this.password = password;
        this. userId = userId;
    }

    public CredentialDto(){}

    @Id
    public String username;

    public String password;

    @Column(name = "user_id", unique = true)
    public String userId;
}
