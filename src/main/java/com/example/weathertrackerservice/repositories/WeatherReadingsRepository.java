package com.example.weathertrackerservice.repositories;

import com.example.weathertrackerservice.entities.WeatherReadings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WeatherReadingsRepository extends JpaRepository<WeatherReadings, Void> {
    @Query(value = "select * from weather_readings where user_name=:userName order by updated_date_time desc limit 15", nativeQuery = true)
    Optional<List<WeatherReadings>> findByUserName(String userName);
}
