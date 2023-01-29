package com.andes.metamon.service.email.dto.response;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailConfirmResponseDto {
    private String confirmCode;

    public static EmailConfirmResponseDto of(String confirmCode) {
        return new EmailConfirmResponseDto(confirmCode);
    }
}
