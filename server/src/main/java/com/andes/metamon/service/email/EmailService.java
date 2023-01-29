package com.andes.metamon.service.email;

import com.andes.metamon.config.common.mail.RegisterMail;
import com.andes.metamon.domain.user.UserRepository;
import com.andes.metamon.exception.badRequest.DuplicateEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final UserRepository userRepository;
    private final RegisterMail registerMail;

    public String sendSimpleMessage(String email) throws Exception{
        validdateEmailDuplicate(email);
        return registerMail.sendSimpleMessage(email);
        // 이메일 보내기
    }
    public void checkEmailCertificateCodeMatch(String email) {
        validdateEmailDuplicate(email);
        // 이메일 보내기
    }
    public void validdateEmailDuplicate(String email) {
        if (userRepository.existsUserByEmail(email)) {
            throw new DuplicateEmail();
        }
    }

}
