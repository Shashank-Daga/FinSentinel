package com.finsentinel.event;

public interface FraudEventPublisher {
    void publish(FraudEvent event);
}
