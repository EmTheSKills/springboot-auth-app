package ca.ulaval.glo3202.authapp.application;

import java.util.ArrayList;
import java.util.Optional;

import ca.ulaval.glo3202.authapp.application.assemblers.UserAssembler;
import ca.ulaval.glo3202.authapp.application.dtos.CredentialDto;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import ca.ulaval.glo3202.authapp.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthService implements UserDetailsService {

    private final CredentialRepository credentialRepository;
    private final UserRepository userRepository;


    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserFactory userFactory;

    //A travailler
    private PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthService(CredentialRepository credentialRepository, UserRepository userRepository) {
        this.credentialRepository = credentialRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //UserCreationDto userDto = userRepository.findUserByUsername(username);
        CredentialDto credentials = credentialRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        //String password = userRepository.getPasswordFromUsername(username);
        /*
        if (credentials == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
         */
        return new org.springframework.security.core.userdetails.User(credentials.username, credentials.password,
                new ArrayList<>());
    }

    @Transactional
    public UserCreationDto createUserAccount(SignUpDto dto) {
        UserDomain user = userFactory.createUser(dto);
        UserCreationDto userDto = userAssembler.toUserCreationDto(user);
        CredentialDto credentialDto = userAssembler.toCredentialDto(user, bcryptEncoder.encode(dto.password));
        credentialRepository.save(credentialDto);
        return userRepository.save(userDto);
    }
}