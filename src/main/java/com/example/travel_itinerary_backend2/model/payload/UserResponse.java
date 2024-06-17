package com.example.travel_itinerary_backend2.model.payload;

import com.example.travel_itinerary_backend2.model.enums.AuthProvider;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private AuthProvider authProvider;
    private String name;
    private String imageUrl;

}
