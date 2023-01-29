package com.andes.metamon.exception.internelServer;

import com.andes.metamon.exception.BaseResponseStatusCode;
import com.andes.metamon.exception.CustomExcetion;

import static com.andes.metamon.exception.BaseResponseStatusCode.QRCODE_UPLOAD_S3_FAILED;

public class QrCodeUploadFail extends CustomExcetion {
    public QrCodeUploadFail() {
        super(QRCODE_UPLOAD_S3_FAILED.getMessage(), QRCODE_UPLOAD_S3_FAILED);
    }
}
