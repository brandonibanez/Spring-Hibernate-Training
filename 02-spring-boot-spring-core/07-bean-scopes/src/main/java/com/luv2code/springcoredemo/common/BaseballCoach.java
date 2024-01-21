package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("In constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do the Baseball Moves!";
    }
}
