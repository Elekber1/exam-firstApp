package com.example.weatherinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherInfoApplication.class, args);
    }

}
