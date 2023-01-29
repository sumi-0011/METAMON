package com.andes.metamon.controller.idcard;

import com.andes.metamon.config.common.Login;
import com.andes.metamon.config.common.VerifiedMember;
import com.andes.metamon.config.jwt.MemberPayload;
import com.andes.metamon.controller.idcard.dto.request.UploadRequestIdCardDto;
import com.andes.metamon.exception.BaseResponse;
import com.andes.metamon.service.idcard.IdCardService;
import com.andes.metamon.service.idcard.dto.request.UploadRequestServiceIdCardDto;
import com.andes.metamon.service.idcard.dto.response.ResponseIdCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/auth")
public class IdCardController {
    private final IdCardService idCardService;

    // 신분증 qr 이미지 등록
    @PostMapping("")
    @Login
    public ResponseEntity<BaseResponse> saveQRImage(@RequestBody final UploadRequestIdCardDto request,
                                                    @VerifiedMember final MemberPayload requestMember) {
        idCardService.saveIdCard(requestMember.getId(), request.toServiceDto());
        return ResponseEntity.ok().body(new BaseResponse<>(null));
    }
    // 신분증 조회 - User ID Card

    // 신분증 조회 - 모든 카드 다 가져오기
    @GetMapping("")
    @Login
    public ResponseEntity<BaseResponse> findAllIdCard(@VerifiedMember final MemberPayload requestMember) {
        List<ResponseIdCardDto> response = idCardService.findAllIdCard(requestMember.getId());
        return ResponseEntity.ok().body(new BaseResponse<List<ResponseIdCardDto>>(response));
    }

    // 신분증 qr 이미지 삭제

}
