package com.example.weatherinfo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDTO {


    private Long id;
    @NotEmpty(message = "name city must not be empty")
    private String city;
    private LocalDate date;
    private String temp;
}
