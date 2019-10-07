package com.example.weatherinfo.service.Impl;

import com.example.weatherinfo.dao.model.WeatherEntity;
import com.example.weatherinfo.dao.repository.WeatherRepository;
import com.example.weatherinfo.mapper.WeatherMapper;
import com.example.weatherinfo.model.WeatherDTO;
import com.example.weatherinfo.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDTO> getAll() {
        logger.info("service layer findAllWeathers : ");
        return WeatherMapper.INSTANCE.entityListToWeatherDTOList((List<WeatherEntity>) weatherRepository.findAll());
    }

    @Override
    public WeatherDTO addWeather(WeatherDTO weatherDTO) {
        logger.info("service layer addWeather : ");
        WeatherEntity weatherEntity = weatherRepository.save(WeatherMapper.INSTANCE.weatherDTOToEntity(weatherDTO));
        return weatherDTO;
    }

    @Override
    public WeatherDTO findById(Long id) {
        logger.info("service layer findById: ");
        WeatherEntity weatherEntity = weatherRepository.findById(id).orElse(null);
        return WeatherMapper.INSTANCE.entityToWeatherDTO(weatherEntity);
    }

    @Override
    public WeatherDTO updateWeather(WeatherDTO weatherDTO, Long id) {
        logger.info("service layer updateWeather: ");
        WeatherEntity weatherEntity = weatherRepository.findById(id).orElse(null);
        weatherRepository.save(weatherEntity);
        return weatherDTO;
    }

    @Override
    public WeatherDTO deleteWeather(Long id) {
        logger.info("service layer deleteWeather: ");
        WeatherEntity weatherEntity = weatherRepository.findById(id).orElse(null);
        weatherRepository.delete(weatherEntity);
        return WeatherMapper.INSTANCE.entityToWeatherDTO(weatherEntity);
    }

    @Override
    public List<WeatherDTO> findByCity(String city) {
        logger.info("service layer findByCity: ");
        List<WeatherEntity> weatherEntityList = weatherRepository.findByCity(city);
        return WeatherMapper.INSTANCE.entityListToWeatherDTOList(weatherEntityList);
    }

    @Override
    public List<WeatherDTO> findByDate(LocalDate date) {
        logger.info("service layer findByDate: ");
        List<WeatherEntity> weatherEntityList = weatherRepository.findByDate(date);
        return WeatherMapper.INSTANCE.entityListToWeatherDTOList(weatherEntityList);
    }

    @Override
    public List<WeatherDTO> findByCityAndDate(String city, LocalDate date) {
        logger.info("service layer findByCityAndDate: ");
        List<WeatherEntity> weatherEntityList = weatherRepository.findByCityAndDate(city, date);
        return WeatherMapper.INSTANCE.entityListToWeatherDTOList(weatherEntityList);
    }

    @Override
    public List<WeatherDTO> findByCites(String city1, String city2) {
        logger.info("service layer findByCites: ");
        List<WeatherEntity> weatherEntityList = weatherRepository.findByCites(city1, city2);
        return WeatherMapper.INSTANCE.entityListToWeatherDTOList(weatherEntityList);
    }

}
