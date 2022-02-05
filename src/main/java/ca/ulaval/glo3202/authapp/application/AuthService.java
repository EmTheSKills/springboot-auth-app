package ca.ulaval.glo3202.authapp.application;

import java.util.ArrayList;

import ca.ulaval.glo3202.authapp.application.dtos.assemblers.UserAssembler;
import ca.ulaval.glo3202.authapp.application.dtos.CredentialsDto;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.application.exception.UserNotFoundException;
import ca.ulaval.glo3202.authapp.application.exception.UsernameAlreadyUseException;
import ca.ulaval.glo3202.authapp.domain.repositories.CredentialsRepository;
import ca.ulaval.glo3202.authapp.domain.repositories.UserRepository;
import ca.ulaval.glo3202.authapp.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthService implements UserDetailsService {

    private final CredentialsRepository credentialsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    public AuthService(CredentialsRepository credentialsRepository, UserRepository userRepository) {
        this.credentialsRepository = credentialsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsDto credentials = credentialsRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(credentials.username, credentials.password,
                new ArrayList<>());
    }

    @Transactional
    public UserDto createUserAccount(SignUpDto dto) {
        userAleardyExist(dto.username);
        User user = userFactory.createUser(dto);
        UserDto userDto = userAssembler.toUserCreationDto(user);
        CredentialsDto credentialsDto = userAssembler.toCredentialsDto(user, bcryptEncoder.encode(dto.password));
        credentialsRepository.save(credentialsDto);
        return userRepository.save(userDto);
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.findById(username).orElseThrow(UserNotFoundException::new);
    }

    private void userAleardyExist(String username) {
        try{
            getUserByUsername(username);
            throw new UsernameAlreadyUseException();
        } catch (UserNotFoundException e){}
    }
}