package fr.lernejo.travelsite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.ArrayList;
import java.util.List;

public interface Service {

@GET("/api/temperature")
    Call<Temperatures> GetTemperatures(@Query("country") String country);

    public record Temperatures(String country,
                               ArrayList<Temperature> temperatures) {

        public record Temperature(String date,
                                  Double temperature){}

    }


}
