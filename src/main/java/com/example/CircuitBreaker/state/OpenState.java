package com.example.CircuitBreaker.state;

import com.example.CircuitBreaker.Circuit;

public class OpenState implements StateInterface{

    final Circuit circuit;
    long endTimestamp;

    public OpenState(Circuit circuit) {
        this.circuit = circuit;
        this.endTimestamp = System.currentTimeMillis() + circuit.getCircuitConfig().getMaxWaitTime();
    }

    @Override
    public boolean isCircuitClosed() {

        if(System.currentTimeMillis() >= endTimestamp) {
            circuit.changeStateToPartialOpen();
            return circuit.isCircuitClosed();
        }
        System.out.println("Circuit is Open, Please wait!!");
         return false;
    }

    @Override
    public void recordFailure() {


    }

    @Override
    public void recordSuccess() {

    }
}
