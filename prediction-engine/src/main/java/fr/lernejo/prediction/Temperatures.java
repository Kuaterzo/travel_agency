package fr.lernejo.prediction;

import java.util.ArrayList;

public record Temperatures(String country,
                           ArrayList<Temperature> temperatures) {

    public record Temperature(String date,
        Double temperature){}

}
