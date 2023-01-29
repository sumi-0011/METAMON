package com.andes.metamon.exception.invalidToken;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.TOKEN_INVALID_FORM;

public class InvalidTokenForm extends CustomExcetion {
    public InvalidTokenForm() {
        super(TOKEN_INVALID_FORM.getMessage(), TOKEN_INVALID_FORM);
    }
}
