package com.andes.metamon.service.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoDto {
    private Long userId;
    private String userName;
    private String email;
    private String userBirth;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    public static UserInfoDto of(Long userId, String userName, String email, String userBirth, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new UserInfoDto(userId, userName, email, userBirth, createdAt, updatedAt);
    }
}