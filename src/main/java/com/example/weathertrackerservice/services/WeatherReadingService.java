package com.example.weathertrackerservice.services;

import com.example.weathertrackerservice.entities.WeatherReadings;
import com.example.weathertrackerservice.models.responses.HistoryResponse;
import com.example.weathertrackerservice.repositories.WeatherReadingsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class WeatherReadingService {
    private final WeatherReadingsRepository weatherReadingsRepository;

    public void saveWeatherForUser(String userName, Float value){
            val t = weatherReadingsRepository.save(
                    WeatherReadings.builder()
                            .userName(userName)
                            .value(value)
                            .build());
            log.info("Inserted weather Object: {}", t);
    }

    public HistoryResponse getWeatherData(String userName) {
        val resp = new ArrayList<>(weatherReadingsRepository.findByUserName(userName).orElse(List.of()));
        Collections.reverse(resp);
        val finalResp = resp.stream().map(
                reading -> {
                   return HistoryResponse.TemperatureMapping.builder()
                            .temp(reading.getValue())
                            .time(reading.getUpdatedDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")))
                            .build();
                }
        ).toList();
        return HistoryResponse.builder().response(finalResp).build();
    }
}
