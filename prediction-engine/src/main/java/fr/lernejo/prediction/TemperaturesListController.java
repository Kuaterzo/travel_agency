package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TemperaturesListController {

    private final TemperatureService temperatureService = new TemperatureService();

    @GetMapping("/api/temperature")
    public Temperatures AddTemperratures(@RequestParam String country){

        ArrayList<Temperatures.Temperature> temperature = new ArrayList<>();
        temperature.add(new Temperatures.Temperature("2022-01-10",temperatureService.getTemperature(country)));
        temperature.add(new Temperatures.Temperature("2022-01-11",temperatureService.getTemperature(country)));
        Temperatures temperatures1 = new Temperatures(country, temperature);

        return temperatures1;
    }
}
