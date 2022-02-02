package ca.ulaval.glo3202.authapp.application;

import java.util.ArrayList;

import ca.ulaval.glo3202.authapp.application.assemblers.UserAssembler;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserFactory userFactory;

    //A travailler
    private PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //UserCreationDto userDto = userRepository.findById()
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserCreationDto createUserAccount(SignUpDto dto) {
        UserDomain user = userFactory.createUser(dto, bcryptEncoder);
        UserCreationDto userDto = userAssembler.toUserCreationDto(user);;

        return userRepository.save(userDto);

    }
}