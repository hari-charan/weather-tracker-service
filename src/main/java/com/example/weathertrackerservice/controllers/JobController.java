package com.example.weathertrackerservice.controllers;

import com.example.weathertrackerservice.models.requests.ScheduleCreateRequest;
import com.example.weathertrackerservice.models.responses.HistoryResponse;
import com.example.weathertrackerservice.services.TaskSchedulingService;
import com.example.weathertrackerservice.services.UserDetailsService;
import com.example.weathertrackerservice.services.WeatherReadingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class JobController {
    private final TaskSchedulingService taskSchedulingService;
    private final WeatherReadingService weatherReadingService;

    @PostMapping("/schedule")
    public Boolean scheduleTask(
            @RequestBody ScheduleCreateRequest request
            ) {
        return taskSchedulingService.saveUserDetailsAndInitiateJob(request);
    }

    @GetMapping("/get/history")
    public HistoryResponse getHistory(
            @RequestParam("user_name") String userName
    ) {
        return weatherReadingService.getWeatherData(userName);
    }
}
