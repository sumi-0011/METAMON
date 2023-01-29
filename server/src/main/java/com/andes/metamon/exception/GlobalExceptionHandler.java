package com.andes.metamon.exception;

import com.andes.metamon.exception.badRequest.*;
import com.andes.metamon.exception.internelServer.MailPostErrorException;
import com.andes.metamon.exception.internelServer.QrCodeUploadFail;
import com.andes.metamon.exception.invalidToken.ExpiredToken;
import com.andes.metamon.exception.invalidToken.InvalidTokenForm;
import com.andes.metamon.exception.invalidToken.NotRequiredToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundUser.class)
    public ResponseEntity<BaseExceptionResponse> handleNotFoundException(final NotFoundUser e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(NotMatchPassword.class)
    public ResponseEntity<BaseExceptionResponse> handleNotMatchPasswordException(final NotMatchPassword e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(DuplicateEmail.class)
    public ResponseEntity<BaseExceptionResponse> handleDuplicateEmailException(final DuplicateEmail e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(InvalidTokenForm.class)
    public ResponseEntity<BaseExceptionResponse> handleInvalidTokenFormException(final InvalidTokenForm e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(NotFoundTokenFromHeader.class)
    public ResponseEntity<BaseExceptionResponse> handleNotFoundTokenFromHeaderException(final NotFoundTokenFromHeader e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(ExpiredToken.class)
    public ResponseEntity<BaseExceptionResponse> handleExpiredTokenException(final ExpiredToken e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(NotRequiredToken.class)
    public ResponseEntity<BaseExceptionResponse> handleNotRequiredTokenException(final NotRequiredToken e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(QrCodeUploadFail.class)
    public ResponseEntity<BaseExceptionResponse> handleQrCodeUploadFailException(final QrCodeUploadFail e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(MailPostErrorException.class)
    public ResponseEntity<BaseExceptionResponse> handleMailPostErrorException(final MailPostErrorException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(DuplicateIdCardPlatform.class)
    public ResponseEntity<BaseExceptionResponse> handleDuplicateIdCardPlatformException(final DuplicateIdCardPlatform e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseExceptionResponse.of(e));
    }
    @ExceptionHandler(NotMatchPlatform.class)
    public ResponseEntity<BaseExceptionResponse> handleNotMatchPlatformException(final NotMatchPlatform e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseExceptionResponse.of(e));
    }
}
