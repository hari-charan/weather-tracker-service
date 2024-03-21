package com.example.weathertrackerservice.repositories;

import com.example.weathertrackerservice.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Void> {
    Optional<UserDetails> findByUserName(String userName);
}
