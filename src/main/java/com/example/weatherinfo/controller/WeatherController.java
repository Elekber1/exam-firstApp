package com.example.weatherinfo.controller;


import com.example.weatherinfo.model.WeatherDTO;
import com.example.weatherinfo.scheduler.service.CitiesService;
import com.example.weatherinfo.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/weather")
@Api(value = "Weather Management System")
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CitiesService citiesService;

    @ApiOperation(value = "View a list of available weathers")
    @GetMapping("/")
    public List<WeatherDTO> findAllWeathers() {
        logger.info("findAllWeathers: ");
        return weatherService.getAll();
    }


    @ApiOperation(value = "Get a weather by id")
    @GetMapping("/byId/{id}")
    public WeatherDTO findById(
            @ApiParam(value = "Weather", required = true)
            @PathVariable
            @Min(value = 1, message = "id must be greater than or equal 1")
            @Max(value = 1000, message = "id must be lower than or equal to 1000")
                    Long id) {
        logger.info("findById: ");
        return weatherService.findById(id);
    }

    @ApiOperation(value = "Get a weather by city")
    @GetMapping("/byCity/{city}")
    public List<WeatherDTO> findByCity(@PathVariable String city) {
        logger.info("findByCity: ");
        return weatherService.findByCity(city);
    }

    @ApiOperation(value = "Get a weather by date")
    @GetMapping("/byDate/{date}")
    public List<WeatherDTO> findByDate(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @PathVariable LocalDate date) {
        logger.info("findByDate: ");
        return weatherService.findByDate(date);
    }

    @ApiOperation(value = "Get a weather by city and by date")
    @GetMapping("/byCityAndByDate/{city}/{date}")
    public List<WeatherDTO> findByDateAndCity(@PathVariable String city,
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                              @PathVariable LocalDate date) {
        logger.info("findByDateAndCity: ");
        return weatherService.findByCityAndDate(city, date);
    }

    @ApiOperation(value = "Add a weather")
    @PostMapping("/")
    public ResponseEntity<WeatherDTO> createWeather(
            @RequestBody WeatherDTO weatherDTO) {
        logger.info("createWeather: ");
        weatherService.addWeather(weatherDTO);
        return ResponseEntity.ok(weatherDTO);
    }

    @ApiOperation(value = "Update a weather")
    @PutMapping("/{id}")
    public ResponseEntity<WeatherDTO> updateCustomer(@PathVariable Long id,
                                                     @RequestBody WeatherDTO weatherDTO) {
        logger.info("updateCustomer: ");
        weatherService.updateWeather(weatherDTO, id);
        return ResponseEntity.ok(weatherDTO);
    }

    @ApiOperation(value = "Delete a weather")
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCustomerById(@PathVariable
                                                   @Min(value = 1, message = "id must be greater than or equal 1")
                                                   @Max(value = 1000, message = "id must be lower than or equal to 1000")
                                                           Long id) {
        logger.info("deleteCustomerById: ");
        weatherService.deleteWeather(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @ApiOperation(value = "Get a weather by cities")
    @GetMapping("/setCities/{city1}/{city2}")
    public List<WeatherDTO> setCities(
            @PathVariable String city1,
            @PathVariable String city2) {
        logger.info("setCities: ");
        citiesService.setCity1(city1);
        citiesService.setCity2(city2);
        return weatherService.findByCites(city1, city2);
    }

}
