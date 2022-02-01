package ca.ulaval.glo3202.authapp.application.dtos;

public class AccountCreationDto {
    private final UserCreationDto user;
    private final UserPasswordCreationDto password;

    public AccountCreationDto(UserCreationDto user, UserPasswordCreationDto password) {
        this.user = user;
        this.password = password;
    }

}
