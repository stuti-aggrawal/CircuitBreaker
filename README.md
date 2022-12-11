# Circuit Breaker Design Pattern

It supports the 3 states:
- OPEN
- CLOSED
- PARTIAL_OPEN

The following values can be configured to use this circuit breaker - 

 - failureThreshold -> this property defines total consecutive failures to reach before circuit breaks
 - maxWaitTime -> this property defines time in ms after which the circuit would partial open
 - successThresholdPartialOpenState -> number of success to close the circuit from partial open state
 - failureThresholdPartialOpenState -> number of failures to open the circuit from partial open state

## How to use?

Add @CircuitBreaker annotation to any service we want to apply circuit breaker design pattern.

    @CircuitBreaker
    public void process(){}

## How to test?

As per current implementation the Driver Service will randomly fail or pass.
First run the Spring boot application  - "CircuitBreakerApplication.java" .
Try to ping below url multiple times to simulate the circuit breaker.

$ curl --location --request GET 'http://localhost:8080/test'

## FAQ's

For PARTIAL_OPEN state following strategies can be considered
- latency based
- request count

The design is highly decoupled as the service and circuit breaker are completely independent of each other although implemented in same project.

The current solution can be used in a distributed manner by storing the InitialStats.java in a common datastore and could be used by multiple services. 