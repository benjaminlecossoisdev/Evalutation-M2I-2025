package org.example.evaltest.controller;

import org.example.evaltest.model.Time;
import org.example.evaltest.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private TimeRepository timeRepository;


    @GetMapping("/time")
        public String time(){
        Time heureActuelle = new Time();
        heureActuelle.setHeure(LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
        timeRepository.save(heureActuelle);

        return "Voici l'heure actuelle :" + heureActuelle.getHeure();
        }

    @GetMapping("/times")
    public String times(){
        List<Time> ListeBdd = new ArrayList<Time>();
         ListeBdd = timeRepository.findAllByOrderByHeureDesc();

         List<LocalTime> listeHeures = new ArrayList<>();

        for (Time time : ListeBdd) {
            listeHeures.add(time.getHeure());
        }



        return "Voici tous les enregitrements" + listeHeures;
    }
}
