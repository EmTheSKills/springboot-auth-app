package ca.ulaval.glo3202.authapp.domain.user;

public class UserEncryptPassword {

    private final String password;

    public UserEncryptPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
