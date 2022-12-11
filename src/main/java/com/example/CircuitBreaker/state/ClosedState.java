package com.example.CircuitBreaker.state;

import com.example.CircuitBreaker.Circuit;
import com.example.CircuitBreaker.InitialStats;

public class ClosedState implements StateInterface {

    final Circuit circuit;
    InitialStats initialStats;

    public ClosedState(Circuit circuit) {
        this.circuit = circuit;
        this.initialStats = new InitialStats();
    }

    @Override
    public boolean isCircuitClosed() {
        return true;
    }

    @Override
    public void recordFailure() {
        initialStats.failureCount++;
        System.out.println("Failure count - " + initialStats.failureCount);
        if (initialStats.failureCount >= circuit.getCircuitConfig().getFailureThreshold()) {
            circuit.changeStateToOpen();
        }

    }

    @Override
    public void recordSuccess() {
        initialStats.failureCount = 0;
    }


}
