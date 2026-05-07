package com.finsentinel.stream;

import com.finsentinel.model.FraudAlert;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocalAlertPublisher implements EventPublisher<FraudAlert>{
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(FraudAlert alert){
        publisher.publishEvent(alert);
    }
}
