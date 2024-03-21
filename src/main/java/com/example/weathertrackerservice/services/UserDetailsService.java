package com.example.weathertrackerservice.services;

import com.example.weathertrackerservice.entities.UserDetails;
import com.example.weathertrackerservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsService {
    private final UserRepository userRepository;

    public Boolean saveUser(String userName, Integer time, String latitude, String longitude){
        val k = userRepository.findByUserName(userName).orElse(null);
        if(Objects.isNull(k)) {
            val t = userRepository.save(
                    UserDetails.builder()
                            .userName(userName)
                            .time(time)
                            .latitude(latitude)
                            .longitude(longitude)
                            .build());
            log.info("Added new object: {}", t);
            return true;
        } else {
            log.info("Failed to create new record");
            return false;
        }
    }
}
