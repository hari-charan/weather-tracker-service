package com.example.weathertrackerservice.models.responses;

import org.springframework.data.util.Pair;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class HistoryResponse {
    @JsonProperty("history")
    List<TemperatureMapping> response;

    @Data
    @Builder
    public static class TemperatureMapping {
        @JsonProperty("time")
        String time;
        @JsonProperty("temperature")
        Float temp;
    }
}
