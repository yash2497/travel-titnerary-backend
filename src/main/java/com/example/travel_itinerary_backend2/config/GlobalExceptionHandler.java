package com.example.travel_itinerary_backend2.config;

import com.example.travel_itinerary_backend2.error.ErrorMessage;
import com.example.travel_itinerary_backend2.error.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleAuthenticationException(AuthenticationException e) {
        ErrorMessage message = new ErrorMessage(
                e.getMessage(),
                HttpStatus.UNAUTHORIZED
        );
        log.error("AuthenticationException: ", e);

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(message);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(BadRequestException e) {
        ErrorMessage message = new ErrorMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );

        log.error("BadRequestException: ", e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(message);
    }
}
