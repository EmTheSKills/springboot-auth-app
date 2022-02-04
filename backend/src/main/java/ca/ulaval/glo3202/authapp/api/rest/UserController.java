package ca.ulaval.glo3202.authapp.api.rest;

import ca.ulaval.glo3202.authapp.api.dtos.assemblers.UserDtoAssembler;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserResponse;
import ca.ulaval.glo3202.authapp.api.validation.UserResourceValidator;
import ca.ulaval.glo3202.authapp.application.UserService;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserResourceValidator userResourceValidator;

    @Autowired
    private UserDtoAssembler userDtoAssembler;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserContent(@PathVariable String username, Principal principal) {
        userResourceValidator.usernameMatchPrincipal(username, principal);
        UserDto userDto = userService.getUserByUsername(username);
        UserResponse response = userDtoAssembler.toUserResponse(userDto);

        return ResponseEntity.ok(response);
    }
}
