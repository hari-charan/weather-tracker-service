package com.example.weathertrackerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "WeatherReadings")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class WeatherReadings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userName;
    Float value;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
}
