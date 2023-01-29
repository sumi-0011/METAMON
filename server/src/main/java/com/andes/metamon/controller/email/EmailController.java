package com.andes.metamon.controller.email;

import com.andes.metamon.config.common.mail.RegisterMail;
import com.andes.metamon.exception.BaseResponse;
import com.andes.metamon.service.email.EmailService;
import com.andes.metamon.service.email.dto.response.EmailConfirmResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email/confirm")
    public ResponseEntity<BaseResponse> signup(@RequestParam(required = true) final String email) throws Exception{
        String confirmCode = emailService.sendSimpleMessage(email);
        return ResponseEntity.ok().body(new BaseResponse<EmailConfirmResponseDto>(EmailConfirmResponseDto.of(confirmCode)));
    }

}
