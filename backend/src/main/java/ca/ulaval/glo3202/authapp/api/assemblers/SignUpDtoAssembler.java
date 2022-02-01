package ca.ulaval.glo3202.authapp.api.assemblers;

import ca.ulaval.glo3202.authapp.api.dtos.SignUpRequest;
import ca.ulaval.glo3202.authapp.api.dtos.SignUpResponse;
import ca.ulaval.glo3202.authapp.application.dtos.SignUpDto;
import ca.ulaval.glo3202.authapp.application.dtos.UserCreationDto;
import org.springframework.stereotype.Component;

@Component
public class SignUpDtoAssembler {

    public SignUpDto toDto(SignUpRequest signUpRequest) {
        SignUpDto dto = new SignUpDto();
        dto.firstName = signUpRequest.firstName;
        dto.lastName = signUpRequest.lastName;
        dto.username = signUpRequest.username;
        dto.email = signUpRequest.email;
        dto.password = signUpRequest.password;
        return dto;
    }

    public SignUpResponse toResponse(UserCreationDto userCreationDto) {
        SignUpResponse response = new SignUpResponse();
        response.id = userCreationDto.id;
        response.email = userCreationDto.email;
        response.username = userCreationDto.username;
        return response;
    }
}
