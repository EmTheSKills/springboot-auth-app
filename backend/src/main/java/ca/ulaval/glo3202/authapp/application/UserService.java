package ca.ulaval.glo3202.authapp.application;

import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import ca.ulaval.glo3202.authapp.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<UserDto> listUser() {
        return userRepository.findAll();
    }
}
