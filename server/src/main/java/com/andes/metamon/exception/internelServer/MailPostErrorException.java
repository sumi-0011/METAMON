package com.andes.metamon.exception.internelServer;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.MAIL_POST_ERROR;

public class MailPostErrorException extends CustomExcetion {
    public MailPostErrorException() {
        super(MAIL_POST_ERROR.getMessage(), MAIL_POST_ERROR);
    }
}
