package com.example.weatherinfo.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weather1")
@ApiModel(description = "All details about the Weather. ")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated the weather Id")
    @Column(name = "id")
    private Long id;
    @ApiModelProperty(notes = "The database generated the city")
    @Column(name = "city")
    private String city;
    @ApiModelProperty(notes = "The database generated the date")
    @Column(name = "date")
    private LocalDate date;
    @ApiModelProperty(notes = "The database generated the temp")
    @Column(name = "temp")
    private String temp;
}


