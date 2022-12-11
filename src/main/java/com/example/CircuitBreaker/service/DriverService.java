package com.example.CircuitBreaker.service;

import com.example.CircuitBreaker.aspect.CircuitBreaker;
import com.example.CircuitBreaker.exception.CustomException;
import org.springframework.stereotype.Component;

@Component
public class DriverService {

    @CircuitBreaker
    public void process(){

        if(Math.random()<0.7){
            throw new CustomException();
        }
        System.out.println("Processing event");
    }
}
