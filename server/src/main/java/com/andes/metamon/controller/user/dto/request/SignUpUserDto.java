package com.andes.metamon.controller.user.dto.request;

import com.andes.metamon.service.user.dto.request.CreateUserServiceDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SignUpUserDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String userName;
    @NotBlank
    private String birth;

    public CreateUserServiceDto toServiecDto() {
        return CreateUserServiceDto.of(email, password, userName, birth);
    }

}
