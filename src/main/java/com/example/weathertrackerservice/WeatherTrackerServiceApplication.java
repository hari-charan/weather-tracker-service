package com.example.weathertrackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherTrackerServiceApplication.class, args);
	}

}
