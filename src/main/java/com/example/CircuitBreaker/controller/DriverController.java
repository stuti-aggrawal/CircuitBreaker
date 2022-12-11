package com.example.CircuitBreaker.controller;

import com.example.CircuitBreaker.exception.CircuitOpenException;
import com.example.CircuitBreaker.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping(value = "/test")
    ResponseEntity<String> testService() {
        try {
            driverService.process();
        } catch (CircuitOpenException e) {
            System.out.println("Circuit Open");
        }
        catch (Exception e){
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
