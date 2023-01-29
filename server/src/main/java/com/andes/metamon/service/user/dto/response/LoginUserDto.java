package com.andes.metamon.service.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUserDto {
    private Long id;
    private String userName;
    private String email;
    private String token;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;
    public static LoginUserDto of(Long id,String userName, String email, String token , LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new LoginUserDto(id, userName, email, token, createdAt, updatedAt);
    }

    public static LoginUserDto of(Long id,String userName, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new LoginUserDto(id, userName, email, "", createdAt, updatedAt);
    }
}