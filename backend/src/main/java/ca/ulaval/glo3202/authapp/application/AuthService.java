package ca.ulaval.glo3202.authapp.application;

import java.util.ArrayList;

import ca.ulaval.glo3202.authapp.application.assemblers.UserAssembler;
import ca.ulaval.glo3202.authapp.application.dtos.CredentialDto;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.domain.repositories.CredentialRepository;
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

    private final CredentialRepository credentialRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    public AuthService(CredentialRepository credentialRepository, UserRepository userRepository) {
        this.credentialRepository = credentialRepository;
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CredentialDto credentials = credentialRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(credentials.username, credentials.password,
                new ArrayList<>());
    }

    @Transactional
    public UserDto createUserAccount(SignUpDto dto) {
        User user = userFactory.createUser(dto);
        UserDto userDto = userAssembler.toUserCreationDto(user);
        CredentialDto credentialDto = userAssembler.toCredentialDto(user, bcryptEncoder.encode(dto.password));
        credentialRepository.save(credentialDto);
        return userRepository.save(userDto);
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}