package ca.ulaval.glo3202.authapp.api.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ulaval.glo3202.authapp.api.security.response.AuthFilterResponse;
import ca.ulaval.glo3202.authapp.api.security.response.AuthFilterResponseUtil;
import ca.ulaval.glo3202.authapp.api.security.response.ExpiredTokenResponse;
import ca.ulaval.glo3202.authapp.api.security.response.UnauthorizedResponse;
import ca.ulaval.glo3202.authapp.application.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthRequestFilter extends OncePerRequestFilter {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthFilterResponseUtil authFilterResponseUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        if ("/api/auth/signin".equals(path) || "/api/auth/signup".equals(path)) {
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = jwtTokenUtil.getAuthTokenFromCookies(request.getCookies(), "token");
        String username;
        try {
            if (jwtToken != null) {

                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

            // Once we get the token validate it.
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.authService.loadUserByUsername(username);

                // if token is valid configure Spring Security to manually set
                // authentication
                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            ExpiredTokenResponse errorResponse = new ExpiredTokenResponse();
            authFilterResponseUtil.parsingFilterResponse(errorResponse, response, HttpStatus.UNAUTHORIZED.value());
        } catch (RuntimeException e) {
            UnauthorizedResponse errorResponse = new UnauthorizedResponse();
            authFilterResponseUtil.parsingFilterResponse(errorResponse, response, HttpStatus.UNAUTHORIZED.value());
        }
    }
}
