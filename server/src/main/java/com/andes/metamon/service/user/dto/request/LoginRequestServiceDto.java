package com.andes.metamon.service.user.dto.request;

import lombok.*;

@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginRequestServiceDto {
    private String email;
    private String password;

    public static LoginRequestServiceDto of(String email, String password) {
        return new LoginRequestServiceDto(email, password);
    }

}
