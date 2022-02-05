package ca.ulaval.glo3202.authapp.application.dtos;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class CredentialsDto {

    public CredentialsDto(String username, String password){
        this.username = username;
        this.password = password;
    }

    public CredentialsDto(){}

    @Id
    public String username;

    public String password;

}
