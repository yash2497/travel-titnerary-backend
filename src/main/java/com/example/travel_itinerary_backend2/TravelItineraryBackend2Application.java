package com.example.travel_itinerary_backend2;

import com.example.travel_itinerary_backend2.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class TravelItineraryBackend2Application {

	public static void main(String[] args) {
		SpringApplication.run(TravelItineraryBackend2Application.class, args);
	}

}
