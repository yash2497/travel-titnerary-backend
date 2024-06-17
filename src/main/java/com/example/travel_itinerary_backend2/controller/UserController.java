package com.example.travel_itinerary_backend2.controller;

import com.example.travel_itinerary_backend2.model.payload.UserResponse;
import com.example.travel_itinerary_backend2.security.CurrentUser;
import com.example.travel_itinerary_backend2.security.UserPrincipal;
import com.example.travel_itinerary_backend2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok(userService.getUserInfoById(userPrincipal.getId()));
    }
}
