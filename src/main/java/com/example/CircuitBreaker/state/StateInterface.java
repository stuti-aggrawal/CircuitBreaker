package com.example.CircuitBreaker.state;

public interface StateInterface {

//    StateType getState();
    boolean isCircuitClosed();
    void recordFailure();
    void recordSuccess();
}
