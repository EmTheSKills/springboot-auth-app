package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.dtos.assemblers.AuthDtoAssembler;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignUpResponse;
import ca.ulaval.glo3202.authapp.api.security.jwt.JwtTokenUtil;
import ca.ulaval.glo3202.authapp.application.AuthService;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignInRequest;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignUpRequest;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.security.Principal;

import static org.springframework.http.HttpHeaders.SET_COOKIE;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
//@CrossOrigin(origins = "https://auth-app-react-frontend.herokuapp.com", allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthDtoAssembler authDtoMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil tokenUtil;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.username, signInRequest.password));
        UserDto userDto = authService.getUserByUsername(signInRequest.username);
        String authToken = tokenUtil.generateToken(signInRequest.username);
        String cookie = tokenUtil.setCookieToken(authToken);

        SignInResponse response = authDtoMapper.toSignInResponse(userDto, authToken);

        return ResponseEntity.ok().header(SET_COOKIE, cookie).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        SignUpDto signUpDto = authDtoMapper.toSignUpDto(signUpRequest);
        UserDto userDto = authService.createUserAccount(signUpDto);

        SignUpResponse response = authDtoMapper.toSignUpResponse(userDto);

        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("/signout")
    public ResponseEntity<Void> logoutUser() {
        return ResponseEntity.ok().header(SET_COOKIE, tokenUtil.emptyCookieToken()).build();
    }

    @GetMapping("/user")
    public ResponseEntity<SignInResponse> isLoggedIn(@CookieValue(name = "token") String token, Principal principal) {
        UserDto userDto = authService.getUserByUsername(principal.getName());

        SignInResponse response = authDtoMapper.toSignInResponse(userDto, token);

        return ResponseEntity.ok(response);
    }
}
