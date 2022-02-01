package ca.ulaval.glo3202.authapp.api.dtos;

import java.io.Serializable;

public class SignInRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    public SignInRequest(){};

    public String username;
    public String password;
}