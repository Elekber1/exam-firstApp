package com.example.weatherinfo.scheduler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class TempService {
    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> temps = new ArrayList<String>() {
        {
            add("30C");
            add("12C");
            add("21C");
            add("40C");
            add("14C");
            add("50C");

        }
    };

    public String getRandomDates() {

        return temps.get(random.nextInt(temps.size()));
    }
}
