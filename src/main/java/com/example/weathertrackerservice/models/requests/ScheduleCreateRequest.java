package com.example.weathertrackerservice.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleCreateRequest {
    @JsonProperty("time")
    Integer time;
    @JsonProperty("user_name")
    String name;
    @JsonProperty("latitude")
    String latitude;
    @JsonProperty("longitude")
    String longitude;
}
