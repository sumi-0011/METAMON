package com.andes.metamon.controller.user.dto.request;

import com.andes.metamon.service.user.dto.request.LoginRequestServiceDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginRequestUserDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginRequestServiceDto toServiecDto() {
        return LoginRequestServiceDto.of(email, password);
    }

}
