package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.assemblers.AuthDtoAssembler;
import ca.ulaval.glo3202.authapp.api.security.JwtTokenUtil;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpResponse;
import ca.ulaval.glo3202.authapp.application.AuthService;
import ca.ulaval.glo3202.authapp.api.dtos.SignInRequest;
import ca.ulaval.glo3202.authapp.api.dtos.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpRequest;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
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
    public ResponseEntity<?> authenticateUser(@RequestBody SignInRequest signInRequest) throws Exception{
        authenticate(signInRequest.username , signInRequest.password);
        UserDetails userDetails = authService.loadUserByUsername(signInRequest.username);
        String token = jwtTokenUtil.generateToken(userDetails);
        UserDto userDto = authService.getUserByUsername(signInRequest.username);
        SignInResponse signInResponse = authDtoMapper.toSignInResponse(userDto, token);

        return ResponseEntity.ok(signInResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {
        SignUpDto signUpDto = authDtoMapper.toSignUpDto(signUpRequest);
        UserDto userDto = authService.createUserAccount(signUpDto);
        SignUpResponse signUpResponse = authDtoMapper.toSignUpResponse(userDto);

        return ResponseEntity.ok(signUpResponse);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Allo");
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            System.out.println("INVALID_CREDENTIALS");
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
