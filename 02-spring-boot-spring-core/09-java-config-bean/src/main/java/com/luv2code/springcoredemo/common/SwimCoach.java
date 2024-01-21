package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do the Swimming Moves!";
    }
}
