package com.andes.metamon.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.andes.metamon.exception.BaseResponseStatusCode.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"status", "message", "data"})
public class BaseResponse<T> {
    private final String message;
    private final int status;

    private T data;

    // 요청에 성공한 경우
    public BaseResponse(T data) {
        this.message = SUCCESS.getMessage();
        this.status = SUCCESS.getStatus();
        this.data = data;
    }

//    public static BaseResponse of(T data) {
//        return new BaseResponse<>(data);
//    }

    // 요청에 실패한 경우

}
