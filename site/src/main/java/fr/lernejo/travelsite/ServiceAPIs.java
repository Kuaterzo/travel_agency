package fr.lernejo.travelsite;

import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class ServiceAPIs {

    private final fr.lernejo.travelsite.Service service;

    public ServiceAPIs(fr.lernejo.travelsite.Service service){

        this.service = service;

    }

    public ArrayList<fr.lernejo.travelsite.Service.Temperatures> ChargePays(){

        ArrayList<fr.lernejo.travelsite.Service.Temperatures> predictions = new ArrayList<>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("countries.txt");
        String content = null;

        try {
            content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stream<String> lines = content.lines();
        lines.forEach(country -> predictions.add(GetTemperature(country)));
        return predictions;

    }

    public fr.lernejo.travelsite.Service.Temperatures GetTemperature(String country){

        Call<fr.lernejo.travelsite.Service.Temperatures> call;
        call = service.GetTemperatures(country);
        fr.lernejo.travelsite.Service.Temperatures prediction = null;

        try {

            prediction = call.execute().body();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return prediction;
    }


}
