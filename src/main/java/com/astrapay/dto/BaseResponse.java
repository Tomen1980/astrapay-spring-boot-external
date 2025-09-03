package com.astrapay.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse <T>{
    private boolean success;
    private String message;
    private T data;
    private Object errors;

    public static <T> BaseResponse<T> success(T data, String message) {
        return BaseResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> error(String message, Object errors) {
        return BaseResponse.<T>builder()
                .success(false)
                .message(message)
                .errors(errors)
                .build();
    }
}
