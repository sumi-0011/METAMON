package com.andes.metamon.config.common.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface MailService {
    public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException;
    public String createKey();
    public String sendSimpleMessage(String to) throws Exception;
}
