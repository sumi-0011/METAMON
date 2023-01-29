package com.andes.metamon.domain.idcard;

import com.andes.metamon.domain.common.BaseEntity;
import com.andes.metamon.domain.user.User;
import com.andes.metamon.service.idcard.dto.request.UploadRequestServiceIdCardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "IDCARDS")
public class IdCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String qrImgUrl;
    @Column
    private String profileImgUrl;
    @Column
    private String nickname;
    // enum
    @Enumerated(EnumType.STRING)
    private Platform platform;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    public IdCard(String qrImgUrl, String profileImgUrl, String nickname, Platform platform, User userId) {
        this.qrImgUrl = qrImgUrl;
        this.profileImgUrl = profileImgUrl;
        this.nickname = nickname;
        this.platform = platform;
        this.userId = userId;
    }

    public static IdCard newInstance(String qrImgUrl, String profileImgUrl, String nickname, Platform platform, User userId) {
        return new IdCard(qrImgUrl,profileImgUrl, nickname, platform, userId);
    }
    public static IdCard newInstance(User userId, String qrImgUrl) {
        // 사용자 qr 이미지는 바뀌어야 할지도?
        return new IdCard(qrImgUrl, null, null, Platform.USER, userId);
    }
    public static IdCard newInstance(UploadRequestServiceIdCardDto request, User userId) {
        IdCard newIdCard = new IdCard("defalutImgUrl",null, "defaultUser", Platform.USER, userId);
        // QR 이미지가 없을 경우, 기본 이미지로 설정 -> 변경되어야하는 값.
        if (!request.getQrImgUrl().isBlank()) {
            newIdCard.setUserIdCardQrImgUrl(request.getQrImgUrl());
        }
        // 유저 닉네임이 없을 경우, 기본 이름으로 설정
        if (!request.getNickname().isBlank()) {
            newIdCard.setUserIdCardNickname(request.getNickname());
        }
        // 신분증의 메타버스 플랫폼 값 설정
        if (!request.getPlatform().isBlank()) {
            newIdCard.setUserIdCardPlatform(request.getPlatform());
        }
        if (!request.getProfileImgUrl().isBlank()) {
            newIdCard.setUserIdCardProfileImgUrl(request.getProfileImgUrl());
        }
        return newIdCard;
    }

    // platform에 들어오는 값에 따라 결정.
    private void setUserIdCardPlatform(String platform) {
        if (platform.equals("ZEPETO")) {
            this.platform = Platform.ZEPETO;
        }
        if (platform.equals("ROBLOX")) {
            this.platform = Platform.ROBLOX;
        }
    }

    public void setUserIdCardQrImgUrl(String qrImgUrl) {
        this.qrImgUrl = qrImgUrl;
    }

    public void setUserIdCardProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }
    public void setUserIdCardNickname(String nickname) {
        this.nickname = nickname;
    }
}
