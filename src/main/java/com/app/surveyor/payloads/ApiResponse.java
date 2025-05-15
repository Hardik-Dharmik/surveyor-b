package com.app.surveyor.payloads;

import lombok.Data;

import java.time.Instant;

@Data
public class ApiResponse<T> {
    private Instant timestamp;
    private int status;
    private String message;
    private T data;
    private Object errors;

    public ApiResponse() {
        this.timestamp = Instant.now();
    }

    public ApiResponse(int status, String message, T data, Object errors) {
        this.timestamp = Instant.now();
        this.status = status;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }
}

