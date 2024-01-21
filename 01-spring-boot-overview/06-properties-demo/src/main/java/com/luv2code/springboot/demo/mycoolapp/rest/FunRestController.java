package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    String name;

    @Value("${coach.name}")
    String club;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "NAME= " + name + " CLUB= " + club;
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Yayaman ka din hehe";
    }

}
