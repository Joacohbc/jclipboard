package com.jclipboard.jclipboard.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonError {

    private String message;
    private String status;
    private int statusCode;

    public JsonError() {
    }

    public JsonError(String message, String status, int statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

    public JsonError(String message, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus.getReasonPhrase();
        this.statusCode = httpStatus.value();
    }

    public ResponseEntity<Map<String, Object>> getResponseEntity() {
        return ResponseEntity.status(statusCode).body(new HashMap<>() {
            {
                put("message", message);
                put("error", message);
                put("status", status);
                put("status_code",statusCode);
            }
        });
    }

    public static ResponseEntity<Map<String, Object>> of(String message, String status, int statusCode) {
        return new JsonError(message, status, statusCode).getResponseEntity();
    }

    public static ResponseEntity<Map<String, Object>> of(String message, HttpStatus httpStatus) {
        return new JsonError(message, httpStatus).getResponseEntity();
    }
}
