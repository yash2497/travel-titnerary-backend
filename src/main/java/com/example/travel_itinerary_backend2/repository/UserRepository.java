package com.example.travel_itinerary_backend2.repository;

import com.example.travel_itinerary_backend2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
