package com.example.CircuitBreaker;

import com.example.CircuitBreaker.config.CircuitConfig;
import com.example.CircuitBreaker.state.ClosedState;
import com.example.CircuitBreaker.state.OpenState;
import com.example.CircuitBreaker.state.PartialOpenState;
import com.example.CircuitBreaker.state.StateInterface;
import org.springframework.stereotype.Component;

@Component
public class Circuit {

    private StateInterface stateInterface ;
    final CircuitConfig circuitConfig;

    public Circuit(CircuitConfig circuitConfig) {
        this.circuitConfig = circuitConfig;
        stateInterface = new ClosedState(this);
    }

    public CircuitConfig getCircuitConfig() {
        return circuitConfig;
    }

    public synchronized boolean isCircuitClosed(){
        return stateInterface.isCircuitClosed();
    }

    public synchronized void recordFailure()
    {
        stateInterface.recordFailure();
    }

    public synchronized void recordSuccess(){
        stateInterface.recordSuccess();
    }

    //change state to closed
    public void changeStateToClosed(){
        System.out.println("**** Change state to close ****");
        stateInterface = new ClosedState(this);
    }

    public void changeStateToOpen(){
        System.out.println("**** Change state to open ****");
        stateInterface = new OpenState(this);
    }

    public void changeStateToPartialOpen(){

        System.out.println("**** Change state to Partial Open ****");
        stateInterface = new PartialOpenState(this);
    }
}
