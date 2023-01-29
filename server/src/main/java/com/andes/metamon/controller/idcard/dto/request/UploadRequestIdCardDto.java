package com.andes.metamon.controller.idcard.dto.request;

import com.andes.metamon.service.idcard.dto.request.UploadRequestServiceIdCardDto;
import lombok.*;

@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UploadRequestIdCardDto {
    private String platform;
    private String nickname;
    private String profileImgUrl;

    public UploadRequestServiceIdCardDto toServiceDto() {
        return UploadRequestServiceIdCardDto.of(platform, nickname, null, profileImgUrl);
    }
}
