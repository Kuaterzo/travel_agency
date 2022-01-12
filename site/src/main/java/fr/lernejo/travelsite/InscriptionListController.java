package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InscriptionListController {

    private final ArrayList<Inscription> inscription = new ArrayList<>();
    private final ServiceAPIs serviceAPIs;

    public InscriptionListController(ServiceAPIs serviceAPIs){

        this.serviceAPIs = serviceAPIs;
    }


    @PostMapping("/api/inscription")
    public void AddInscription(@RequestBody Inscription inscription){

        this.inscription.add(inscription);
    }

    public ArrayList<Travels> ChargementPredTemp(ArrayList<Service.Temperatures> prediction){

        ArrayList<Travels> travels = new ArrayList<>();

        for (Service.Temperatures temp : prediction ){

            double tempAuj = temp.temperatures().get(0).temperature();
            double tempHier = temp.temperatures().get(1).temperature();
            double tempMoy = (tempAuj + tempHier) / 2;

            Travels trav = new Travels(temp.country() , tempMoy);
            travels.add(trav);
        }
        return travels;
    }

    public ArrayList<Travels> TrieTravWarmer(ArrayList<Travels> travels, Inscription insc, double temperatureRef){
        ArrayList<Travels> travelsUpDate = new ArrayList<>();
        for (Travels travel : travels) {
            if(insc.userCountry().equals(travel.country())){
                temperatureRef = travel.temperature() + insc.minimumTemperatureDistance();
            }
        }
        for (Travels travel2 : travels) {
            if (temperatureRef <= travel2.temperature()) {
                travelsUpDate.add(travel2);
            }
        }
        return travelsUpDate;
    }

    public ArrayList<Travels> TrieTravColder(ArrayList<Travels> travels, Inscription insc, double temperatureRef){
        ArrayList<Travels> travelsUpDate = new ArrayList<>();
        for (Travels travel : travels) {
            if(insc.userCountry().equals(travel.country())){
                temperatureRef = travel.temperature() - insc.minimumTemperatureDistance();
            }
        }
        for (Travels travel2 : travels) {
            if (temperatureRef >= travel2.temperature()) {
                travelsUpDate.add(travel2);
            }
        }
        return travelsUpDate;
    }

    @GetMapping("/api/travels")
    public ArrayList<Travels> AddTravels(@RequestParam String userName){
//        ArrayList<Service.Temperatures> prediction = serviceAPIs.ChargePays();
//        ArrayList<Travels> travels = ChargementPredTemp(prediction);
        ArrayList<Travels> travelsUpDate = new ArrayList<>();
//        for(Inscription insc : inscription) {
//            if(insc.userName().equals(userName)) {
//                if(insc.weatherExpectation().equals(Inscription.WeatherExpectation.WARMER)) {
//                    travelsUpDate = TrieTravWarmer(travels, insc ,0.0);
//                }
//                else{
//                    travelsUpDate = TrieTravColder(travels, insc ,0.0);
//                }
//            }
//        }
        return travelsUpDate;
    }
}
