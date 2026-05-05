package com.finsentinel.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternalFraudEventPublisher implements FraudEventPublisher {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(FraudEvent event){
        publisher.publishEvent(event);
    }
}
