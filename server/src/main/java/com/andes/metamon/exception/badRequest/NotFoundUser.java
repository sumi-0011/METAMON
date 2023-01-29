package com.andes.metamon.exception.badRequest;

import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.USER_NOT_FOUND;

public class NotFoundUser extends CustomExcetion {
    public NotFoundUser() {
        super(USER_NOT_FOUND.getMessage(), USER_NOT_FOUND);
    }
}
