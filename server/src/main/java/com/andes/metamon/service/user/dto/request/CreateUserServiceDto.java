package com.andes.metamon.service.user.dto.request;

import lombok.*;

@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CreateUserServiceDto {

    private String email;
    private String password;
    private String name;
    private String birth;

    public static CreateUserServiceDto of(String email, String password, String name, String birth) {
        return new CreateUserServiceDto(email, password, name, birth);
    }
}
