package com.example.weatherinfo.dao.repository;

import com.example.weatherinfo.dao.model.WeatherEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends CrudRepository<WeatherEntity, Long> {

    @Query(value = "select w from WeatherEntity w where w.city= ?1")
    List<WeatherEntity> findByCity(String city);

    @Query(value = "select w from WeatherEntity w where w.date= ?1")
    List<WeatherEntity> findByDate(LocalDate date);

    @Query(value = "select w from WeatherEntity w where w.city= ?1 and w.date = ?2")
    List<WeatherEntity> findByCityAndDate(String city, LocalDate date);

    @Query(value = "select w from WeatherEntity w where w.city= ?1 or w.city = ?2")
    List<WeatherEntity> findByCites(String city1, String city2);

}
