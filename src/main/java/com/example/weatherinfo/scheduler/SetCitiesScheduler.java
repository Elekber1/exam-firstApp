package com.example.weatherinfo.scheduler;

import com.example.weatherinfo.model.WeatherDTO;
import com.example.weatherinfo.scheduler.service.CitiesService;
import com.example.weatherinfo.scheduler.service.DateService;
import com.example.weatherinfo.scheduler.service.TempService;
import com.example.weatherinfo.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public class SetCitiesScheduler {

    private WeatherService weatherServicel;
    private CitiesService citiesService;
    private DateService dateService;
    private TempService tempService;

    public SetCitiesScheduler(WeatherService weatherServicel, CitiesService citiesService, DateService dateService, TempService tempService) {
        this.weatherServicel = weatherServicel;
        this.citiesService = citiesService;
        this.dateService = dateService;
        this.tempService = tempService;
    }

        @Scheduled(fixedRate = 20000)// 20 second
    public void createRandomWeathers() {
        weatherServicel.addWeather(WeatherDTO.builder()
        .city(citiesService.getRandomCities())
        .date(LocalDate.parse(dateService.getRandomDates()))
        .temp(tempService.getRandomDates())
        .build());

    }
}
