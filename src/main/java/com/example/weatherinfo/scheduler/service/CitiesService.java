package com.example.weatherinfo.scheduler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CitiesService {

    Random random = new Random(System.currentTimeMillis());

    List<String> cities = new ArrayList<String>();

    public void setCity1(String city1){
        for (int i=0; i<city1.length(); i++){
            cities.add(city1);
        }
    }

    public void setCity2(String city2){
        for (int i=0; i<city2.length(); i++){
            cities.add(city2);
        }
    }


    public String getRandomCities() {
        return cities.get(random.nextInt(cities.size()));
    }

}
