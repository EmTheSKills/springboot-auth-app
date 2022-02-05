package ca.ulaval.glo3202.authapp.api.dtos.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.user.UserFullDetailsResponse;
import ca.ulaval.glo3202.authapp.api.dtos.user.UserPublicDetailsResponse;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoAssembler {
    public UserFullDetailsResponse toUserFullDetailsResponse(UserDto dto) {
        UserFullDetailsResponse response = new UserFullDetailsResponse();
        response.id = dto.id;
        response.firstName = dto.firstName;
        response.lastName = dto.lastName;
        response.username = dto.username;
        response.email = dto.email;

        return response;
    }

    public List<UserPublicDetailsResponse> toUserPublicDetailsResponse(List<UserDto> dtos) {
        List<UserPublicDetailsResponse> response = new ArrayList<>();
        for (UserDto dto: dtos) {
            UserPublicDetailsResponse content = new UserPublicDetailsResponse();
            content.id = dto.id;
            content.firstName = dto.firstName;
            content.lastName = dto.lastName;
            content.username = dto.username;
            response.add(content);
        }
        return response;
    }
}
