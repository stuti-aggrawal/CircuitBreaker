package com.example.CircuitBreaker.config;

import org.springframework.stereotype.Component;

@Component
public class CircuitConfig {

    private int failureThreshold = 5;
    private long maxWaitTime = 5000;
    private int successThresholdPartialOpenState = 2;
    private int failureThresholdPartialOpenState = 2;

    public int getFailureThreshold() {
        return failureThreshold;
    }

    public long getMaxWaitTime() {
        return maxWaitTime;
    }

    public int getSuccessThresholdPartialOpenState() {
        return successThresholdPartialOpenState;
    }

    public int getFailureThresholdPartialOpenState() {
        return failureThresholdPartialOpenState;
    }
}
