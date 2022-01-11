package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InscriptionListController {

    private final ArrayList<Inscription> inscription = new ArrayList<>();
    private final ArrayList<Travels> travels = new ArrayList<>();


    @PostMapping("/api/inscription")
    public void AddInscription(@RequestBody Inscription inscription){

        this.inscription.add(inscription);
    }

    @GetMapping("/api/travels")
    public ArrayList<Travels> AddTravels(@RequestParam String userName){

        Travels travels = new Travels("bonjourtest", 5.2);
        this.travels.add(travels);

            return this.travels;
    }

}
