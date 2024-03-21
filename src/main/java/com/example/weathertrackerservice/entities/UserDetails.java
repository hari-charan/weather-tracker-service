package com.example.weathertrackerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "UserDetails",
        uniqueConstraints =
            @UniqueConstraint(name = "UQ_USERNAME", columnNames = {"userName"}),
        schema = "haricharan"
)
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userName;
    String latitude;
    String longitude;
    Integer time;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
}
