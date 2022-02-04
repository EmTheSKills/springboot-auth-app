package ca.ulaval.glo3202.authapp.api.dtos.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.user.UserResponse;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoAssembler {
    public UserResponse toUserResponse(UserDto userDto) {
        UserResponse response = new UserResponse();
        response.id = userDto.id;
        response.firstName = userDto.firstName;
        response.lastName = userDto.lastName;
        response.username = userDto.username;
        response.email = userDto.email;

        return response;
    }
}
