package com.example.weathertrackerservice.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherResponse {
    @JsonProperty("coord")
    private Coordinates coordinates;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("main")
    private MainData mainData;

    @JsonProperty("wind")
    private WindData windData;

    @Data
    static class Coordinates {
        private double lon;
        private double lat;
    }

    @Data
    static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

    }

    @Data
    public static class MainData {
        private Float temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
    }

    @Data
    static class WindData {
        private double speed;
        private int deg;
        private double gust;
    }
}
