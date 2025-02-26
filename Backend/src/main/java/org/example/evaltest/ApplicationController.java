package org.example.evaltest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class ApplicationController {
    @GetMapping("/time")
        public String time(){
        LocalTime heure = LocalTime.now();
            return "Heure actuelle :" + heure;
        }
}
