package com.example.travel_itinerary_backend2.error;

public class OAuth2AuthenticationProcessingException extends RuntimeException{
    public OAuth2AuthenticationProcessingException(String message) {
        super(message);
    }
}
