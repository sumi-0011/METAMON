package com.andes.metamon.service.user;

import com.andes.metamon.config.jwt.JwtProvider;
import com.andes.metamon.domain.user.User;
import com.andes.metamon.domain.user.UserRepository;
import com.andes.metamon.exception.badRequest.DuplicateEmail;
import com.andes.metamon.exception.badRequest.NotFoundUser;
import com.andes.metamon.exception.badRequest.NotMatchPassword;
import com.andes.metamon.service.idcard.IdCardService;
import com.andes.metamon.service.user.dto.request.CreateUserServiceDto;
import com.andes.metamon.service.user.dto.request.LoginRequestServiceDto;
import com.andes.metamon.service.user.dto.response.LoginUserDto;
import com.andes.metamon.service.user.dto.response.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final IdCardService idCardService;
    private final JwtProvider jwtProvider;


    // 회원가입
    @Transactional
    public LoginUserDto registerUser(CreateUserServiceDto request) {
//        validdateEmailDuplicate(request.getEmail());
        // 이메일 중복 검사
        // 이메일 인증 필요
        User user = User.newInstance(request.getEmail(), request.getPassword(), request.getName(),request.getBirth());
        userRepository.save(user);
        idCardService.saveUserIdCard(user);
        // 토큰 발급
        String userAccessToken = jwtProvider.createAccessToken(user.getId());
        return LoginUserDto.of(user.getId(), user.getName(), user.getEmail(), userAccessToken, user.getCreated_at(), user.getUpdated_at());
    }

    public LoginUserDto login(LoginRequestServiceDto request) {
        //validate user
        User user = validateUserEmailExists(request);
        validatePasswordMatch(request.getPassword(), user);
        String userAccessToken = jwtProvider.createAccessToken(user.getId());
        return LoginUserDto.of(user.getId(), user.getName(), user.getEmail(), userAccessToken, user.getCreated_at(), user.getUpdated_at());
    }

    public void validatePasswordMatch(String inputPassword, User user) {
        if (!user.getPassword().equals(inputPassword)) {
            throw new NotMatchPassword();
        }
    }
    public void validdateEmailDuplicate(String email) {
        if (userRepository.existsUserByEmail(email)) {
            throw new DuplicateEmail();
        }
    }
    public void validdateUserIdExists(Long userId) {
        if (!userRepository.existsUserById(userId)) {
            throw new NotFoundUser();
        }
    }

    public User validateUserEmailExists(LoginRequestServiceDto request) {
        return userRepository.findUserByEmail(request.getEmail()).orElseThrow(() -> new NotFoundUser());
    }
    public UserInfoDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundUser());
        return UserInfoDto.of(user.getId(), user.getName(), user.getEmail(), user.getBirth(), user.getCreated_at(), user.getCreated_at());
    }
}
