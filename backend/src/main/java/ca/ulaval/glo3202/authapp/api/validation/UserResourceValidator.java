package ca.ulaval.glo3202.authapp.api.validation;

import ca.ulaval.glo3202.authapp.api.exception.badrequest.UsernameDoesNotMatchPrincipalException;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class UserResourceValidator {
    public void usernameMatchPrincipal(String username, Principal principal) {
        if(!username.equals(principal.getName())) {
            throw new UsernameDoesNotMatchPrincipalException();
        }
    }
}
