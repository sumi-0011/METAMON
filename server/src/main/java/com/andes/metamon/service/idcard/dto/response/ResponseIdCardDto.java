package com.andes.metamon.service.idcard.dto.response;

import com.andes.metamon.domain.idcard.Platform;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseIdCardDto {
    private Long authCardId;
    private String nickname;
    private String platform;
    private String qrImgUrl;
    private String profileImgUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;
    private Long userId;
    private String userName;
    private String userEmail;
    private String userBirth;

    public static ResponseIdCardDto of(Long id, String nickname, String platform, String qrImgUrl, String profileImgUrl, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, String userName, String userEmail, String userBirth) {
        return new ResponseIdCardDto(id, nickname, platform, qrImgUrl, profileImgUrl, createdAt, updatedAt,userId, userName, userEmail, userBirth);
    }
}
