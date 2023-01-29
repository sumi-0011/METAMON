package com.andes.metamon.service.idcard.dto.request;

import lombok.*;

@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class UploadRequestServiceIdCardDto {
    private String platform;
    private String nickname;
    private String qrImgUrl;
    private String profileImgUrl;

    public static UploadRequestServiceIdCardDto of(String platform, String nickname, String qrImgUrl, String profileImgUrl) {
        return new UploadRequestServiceIdCardDto(platform, nickname, qrImgUrl, profileImgUrl);
    }
}
