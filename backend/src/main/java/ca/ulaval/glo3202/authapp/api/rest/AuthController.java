package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.dtos.assemblers.AuthDtoAssembler;
import ca.ulaval.glo3202.authapp.api.security.jwt.JwtTokenUtil;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignUpResponse;
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

import static org.springframework.http.HttpHeaders.SET_COOKIE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthDtoAssembler authDtoMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.username, signInRequest.password));
        UserDto userDto = authService.getUserByUsername(signInRequest.username);
        SignInResponse response = authDtoMapper.toSignInResponse(userDto);
        String cookie = jwtTokenUtil.generateStringifyCookieWithJwtToken(signInRequest.username);

        return ResponseEntity.ok().header(SET_COOKIE, cookie).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        SignUpDto signUpDto = authDtoMapper.toSignUpDto(signUpRequest);
        UserDto userDto = authService.createUserAccount(signUpDto);
        SignUpResponse response = authDtoMapper.toSignUpResponse(userDto);

        return ResponseEntity.status(CREATED).body(response);
    }
}
