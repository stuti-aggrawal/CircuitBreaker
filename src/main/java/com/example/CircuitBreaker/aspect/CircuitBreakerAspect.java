package com.example.CircuitBreaker.aspect;

import com.example.CircuitBreaker.Circuit;
import com.example.CircuitBreaker.exception.CircuitOpenException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CircuitBreakerAspect {

    private final Circuit circuit;

    public CircuitBreakerAspect(Circuit circuit) {
        this.circuit = circuit;
    }

    @Before(value = "@annotation(CircuitBreaker)")
    public void beforeStep() {

        System.out.println("Check if circuit is open or not");
        if (!circuit.isCircuitClosed()) {
            throw new CircuitOpenException();
        }
    }

    @AfterReturning(value = "@annotation(CircuitBreaker)")
    public void after(JoinPoint jp) {
        System.out.println(jp);

        circuit.recordSuccess();
        System.out.println("Success call");

    }

    @AfterThrowing(value = "@annotation(CircuitBreaker)")
    public void afterThrow() {

        circuit.recordFailure();
        System.out.println("Failure call");
    }
}
