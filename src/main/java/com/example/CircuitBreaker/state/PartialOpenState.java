package com.example.CircuitBreaker.state;

import com.example.CircuitBreaker.Circuit;
import com.example.CircuitBreaker.InitialStats;

public class PartialOpenState implements StateInterface {

    private final Circuit circuit;
    InitialStats initialStats;

    public PartialOpenState(Circuit circuit) {
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
        System.out.println("Partial open failure - " + initialStats.failureCount);
        if (initialStats.failureCount >= circuit.getCircuitConfig().getFailureThresholdPartialOpenState()) {
            circuit.changeStateToOpen();
        }

    }

    @Override
    public void recordSuccess() {

        initialStats.successCount++;
        System.out.println("Partial open success - " + initialStats.successCount);
        if (initialStats.successCount >= circuit.getCircuitConfig().getSuccessThresholdPartialOpenState()) {
            circuit.changeStateToClosed();
        }
    }
}
