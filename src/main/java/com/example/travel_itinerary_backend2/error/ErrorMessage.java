package com.example.travel_itinerary_backend2.error;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.example.travel_itinerary_backend2.config.CustomDateSeriliazer;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorMessage {

    @JsonSerialize(using = CustomDateSeriliazer.class)
    private LocalDateTime time = LocalDateTime.now();

    private String message;

    private HttpStatus httpStatus;

    public ErrorMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
