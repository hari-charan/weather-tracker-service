package com.example.weathertrackerservice.services;

import com.example.weathertrackerservice.models.responses.WeatherResponse;
import com.example.weathertrackerservice.models.requests.ScheduleCreateRequest;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.*;

@Service
@EnableScheduling
@AllArgsConstructor
public class TaskSchedulingService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
    private final UserDetailsService userDetailsService;
    private final RestTemplate restTemplate;
    private final WeatherReadingService weatherReadingService;

    public Boolean saveUserDetailsAndInitiateJob(ScheduleCreateRequest req) {
        Boolean isInserted = userDetailsService.saveUser(req.getName(), req.getTime(), req.getLatitude(), req.getLongitude());
        if(isInserted) {
            scheduler.scheduleWithFixedDelay(
                    () -> {
                        val url = "https://api.openweathermap.org/data/2.5/weather?lat="+req.getLatitude()+"&lon="+req.getLongitude()+"&appid=fbb74e6723022bee6219497281850b34";
                        val response = restTemplate.getForEntity(
                                url,
                                WeatherResponse.class
                        );
                        if(response.getStatusCode() == HttpStatus.OK) {
                            if(!Objects.isNull(response.getBody())) {
                                val temp = response.getBody().getMainData().getTemp();
                                weatherReadingService.saveWeatherForUser(req.getName(), temp);
                            }
                        }
                    },
                    0,
                    req.getTime(),
                    TimeUnit.MINUTES
            );
        }
        return isInserted;
    }

}

