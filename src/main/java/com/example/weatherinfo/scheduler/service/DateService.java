package com.example.weatherinfo.scheduler.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Service
public class DateService {

    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> dates = new ArrayList<String>() {
        {

            add("2019-10-11");
            add("2019-10-13");
            add("2019-10-14");
            add("2019-10-20");
            add("2019-10-19");

        }
    };

    public String getRandomDates() {

        return dates.get(random.nextInt(dates.size()));
    }
}
