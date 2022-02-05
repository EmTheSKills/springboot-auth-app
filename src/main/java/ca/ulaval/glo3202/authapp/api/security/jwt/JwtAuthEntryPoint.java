package ca.ulaval.glo3202.authapp.api.security.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ulaval.glo3202.authapp.api.security.response.AuthFilterResponseUtil;
import ca.ulaval.glo3202.authapp.api.security.response.DisabledAccountResponse;
import ca.ulaval.glo3202.authapp.api.security.response.InvalidCredentialsResponse;
import ca.ulaval.glo3202.authapp.api.security.response.UnauthorizedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Autowired
    AuthFilterResponseUtil authFilterResponseUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        try {
            throw authException;
        }  catch (DisabledException e) {
            DisabledAccountResponse errorResponse = new DisabledAccountResponse();
            authFilterResponseUtil.parsingFilterResponse(errorResponse, response, HttpStatus.UNAUTHORIZED.value());
        } catch (BadCredentialsException e) {
            InvalidCredentialsResponse errorResponse = new InvalidCredentialsResponse();
            authFilterResponseUtil.parsingFilterResponse(errorResponse, response, HttpStatus.UNAUTHORIZED.value());
        } catch (AuthenticationException e) {
            UnauthorizedResponse errorResponse = new UnauthorizedResponse();
            authFilterResponseUtil.parsingFilterResponse(errorResponse, response, HttpStatus.FORBIDDEN.value());
        }


    }
}
