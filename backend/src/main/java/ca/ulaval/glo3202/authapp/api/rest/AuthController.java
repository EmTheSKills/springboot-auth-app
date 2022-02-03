package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.assemblers.SignUpDtoAssembler;
import ca.ulaval.glo3202.authapp.api.configuration.JwtTokenUtil;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpResponse;
import ca.ulaval.glo3202.authapp.application.AuthService;
import ca.ulaval.glo3202.authapp.api.dtos.SignInRequest;
import ca.ulaval.glo3202.authapp.api.dtos.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpRequest;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
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
    private SignUpDtoAssembler signUpDtoMapper;

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
        Authentication authenticate = authenticate(signInRequest.username , signInRequest.password);

        final UserDetails userDetails = authService.loadUserByUsername(signInRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        SignInResponse signInResponse = new SignInResponse();
        signInResponse.jwtToken = token;
        signInResponse.username = userDetails.getUsername();

        return ResponseEntity.ok(signInResponse);
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


    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {
        SignUpDto signUpDto = signUpDtoMapper.toDto(signUpRequest);
        UserCreationDto userCreationDto = authService.createUserAccount(signUpDto);
        SignUpResponse signUpResponse = signUpDtoMapper.toResponse(userCreationDto);
        return ResponseEntity.ok(signUpResponse);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Allo");
    }
}
