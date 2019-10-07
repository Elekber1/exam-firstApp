package com.example.weatherinfo.service;


import com.example.weatherinfo.model.WeatherDTO;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {

    List<WeatherDTO> getAll();

    WeatherDTO addWeather(WeatherDTO weatherDTO);

    WeatherDTO findById(Long id);

    WeatherDTO updateWeather(WeatherDTO weatherDTO, Long id);

    WeatherDTO deleteWeather(Long id);

    List<WeatherDTO> findByCity(String city);

    List<WeatherDTO> findByDate(LocalDate date);

    List<WeatherDTO> findByCityAndDate(String city, LocalDate date);

    List<WeatherDTO> findByCites(String city1, String city2);
}
