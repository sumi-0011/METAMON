package com.andes.metamon.controller.user;

import com.andes.metamon.config.common.Login;
import com.andes.metamon.config.common.VerifiedMember;
import com.andes.metamon.config.common.qrcode.QrCodeGenerator;
import com.andes.metamon.config.jwt.MemberPayload;
import com.andes.metamon.controller.user.dto.request.LoginRequestUserDto;
import com.andes.metamon.controller.user.dto.request.SignUpUserDto;
import com.andes.metamon.exception.BaseResponse;
import com.andes.metamon.service.user.UserService;
import com.andes.metamon.service.user.dto.response.LoginUserDto;
import com.andes.metamon.service.user.dto.response.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<BaseResponse> signup(@RequestBody @Valid final SignUpUserDto request) {
        LoginUserDto loginUserDto = userService.registerUser(request.toServiecDto());
        return ResponseEntity.ok().body(new BaseResponse<LoginUserDto>(loginUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody @Valid final LoginRequestUserDto request) {
        LoginUserDto loginUserDto = userService.login(request.toServiecDto());
        return ResponseEntity.ok().body(new BaseResponse<LoginUserDto>(loginUserDto));
    }

    @GetMapping("/users/me")
    @Login
    public ResponseEntity<BaseResponse> findById(@VerifiedMember final MemberPayload requestMember) {
        UserInfoDto userInfo = userService.findUserById(requestMember.getId());
        return ResponseEntity.ok().body(new BaseResponse<UserInfoDto>(userInfo));
    }




}
