package com.andes.metamon.config.common.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.andes.metamon.config.common.qrcode.QrCodeGenerator;
import com.andes.metamon.exception.internelServer.QrCodeUploadFail;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Component
public class AwsS3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;
    public String makeFileName(String userId) {
        return "example/"+userId+"/"+String.valueOf(System.currentTimeMillis())+".png";
    }
    public String makeText(String name) {
        return "Hi! "+name;
    }

    public String uploadFileV1(String text, String fileName) {
        try {
            byte[] qrCodeImage = QrCodeGenerator.getQRCodeImage(text, 200, 200);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(MediaType.IMAGE_PNG_VALUE);
            InputStream inputStream = new ByteArrayInputStream(qrCodeImage);
            amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e = " + e);
            throw new QrCodeUploadFail();
        }
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }
}