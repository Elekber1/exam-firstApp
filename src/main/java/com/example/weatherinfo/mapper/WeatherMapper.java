package com.example.weatherinfo.mapper;

import com.example.weatherinfo.dao.model.WeatherEntity;
import com.example.weatherinfo.model.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class WeatherMapper {

    public static final WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "temp", source = "temp")

    })
    public abstract WeatherDTO entityToWeatherDTO(WeatherEntity weatherEntity);


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "temp", source = "temp")

    })
    public abstract WeatherEntity weatherDTOToEntity(WeatherDTO weatherDTO);


    public List<WeatherDTO> entityListToWeatherDTOList(List<WeatherEntity> weatherEntityList) {
        List<WeatherDTO> weatherDTOList = weatherEntityList
                .stream()
                .map(m -> entityToWeatherDTO(m))
                .collect(Collectors.toList());
        return weatherDTOList;
    }

}
