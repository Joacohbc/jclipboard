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

    private String[] messages;
    private String status;
    private int statusCode;

    public JsonError() {
    }

    private JsonError(String[] messages, String status, int statusCode) {
        this.messages = messages;
        this.status = status;
        this.statusCode = statusCode;
    }

    private JsonError(String message, String status, int statusCode) {
        this(new String[] { message }, status, statusCode);
    }

    private JsonError(String message, HttpStatus httpStatus) {
        this(message, httpStatus.getReasonPhrase(), httpStatus.value());
    }

    private JsonError(String[] messages, HttpStatus httpStatus) {
        this(messages, httpStatus.getReasonPhrase(), httpStatus.value());
    }

    private ResponseEntity<Map<String, Object>> getResponseEntity() {
        return ResponseEntity.status(statusCode).body(new HashMap<>() {
            {
                // Si hay más de un mensaje, se agregan al arreglo "messages" y "errors"
                if(messages.length >= 2) {
                    put("messages", messages);
                    put("errors", messages);
                } else {
                    put("message", messages[0]);
                    put("error", messages[0]);
                }

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

    public static ResponseEntity<Map<String, Object>> of(String[] messages, HttpStatus httpStatus) {
        return new JsonError(messages, httpStatus).getResponseEntity();
    }
}
