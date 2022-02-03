package ca.ulaval.glo3202.authapp.api.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpRequest;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpResponse;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AuthDtoAssembler {

    public SignUpDto toSignUpDto(SignUpRequest signUpRequest) {
        SignUpDto dto = new SignUpDto();
        dto.firstName = signUpRequest.firstName;
        dto.lastName = signUpRequest.lastName;
        dto.username = signUpRequest.username;
        dto.email = signUpRequest.email;
        dto.password = signUpRequest.password;

        return dto;
    }

    public SignUpResponse toSignUpResponse(UserDto userDto) {
        SignUpResponse response = new SignUpResponse();
        response.id = userDto.id;
        response.firstName = userDto.firstName;
        response.lastName = userDto.lastName;
        response.email = userDto.email;
        response.username = userDto.username;

        return response;
    }

    public SignInResponse toSignInResponse(UserDto userDto, String token) {
        SignInResponse response = new SignInResponse();
        response.id = userDto.id;
        response.firstName = userDto.firstName;
        response.lastName = userDto.lastName;
        response.username = userDto.username;
        response.email = userDto.email;
        response.token = token;

        return response;
    }
}
