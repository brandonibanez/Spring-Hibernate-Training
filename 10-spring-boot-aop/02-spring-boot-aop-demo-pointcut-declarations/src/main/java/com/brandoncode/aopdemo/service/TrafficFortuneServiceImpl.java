package com.brandoncode.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {

        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy beavy cars on the leavy deavy bars";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire) {
            throw new RuntimeException("Super Accident! Super Duper closing the road ahead!");
        }

        return getFortune();
    }

}
