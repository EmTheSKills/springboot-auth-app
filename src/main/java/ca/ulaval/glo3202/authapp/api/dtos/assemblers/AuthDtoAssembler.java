package ca.ulaval.glo3202.authapp.api.dtos.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.auth.SignInResponse;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignUpRequest;
import ca.ulaval.glo3202.authapp.api.dtos.auth.SignUpResponse;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AuthDtoAssembler {

    public SignUpDto toSignUpDto(SignUpRequest signUpRequest) {
        SignUpDto dto = new SignUpDto();
        dto.username = signUpRequest.username;
        dto.firstName = signUpRequest.firstName;
        dto.lastName = signUpRequest.lastName;
        dto.email = signUpRequest.email;
        dto.password = signUpRequest.password;

        return dto;
    }

    public SignUpResponse toSignUpResponse(UserDto userDto) {
        SignUpResponse response = new SignUpResponse();
        response.username = userDto.username;
        response.firstName = userDto.firstName;
        response.lastName = userDto.lastName;
        response.email = userDto.email;

        return response;
    }

    public SignInResponse toSignInResponse(UserDto userDto, String token) {
        SignInResponse response = new SignInResponse();
        response.username = userDto.username;
        response.firstName = userDto.firstName;
        response.lastName = userDto.lastName;
        response.email = userDto.email;
        response.token = token;

        return response;
    }
}
