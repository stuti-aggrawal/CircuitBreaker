package com.example.CircuitBreaker;

import com.example.CircuitBreaker.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircuitBreakerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CircuitBreakerApplication.class, args);

	}

}
