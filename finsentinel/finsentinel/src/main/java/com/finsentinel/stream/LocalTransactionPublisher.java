package com.finsentinel.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.finsentinel.model.Transaction;

@RequiredArgsConstructor
@Component
public class LocalTransactionPublisher implements EventPublisher<Transaction>{
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(Transaction transaction){
        publisher.publishEvent(transaction);
    }
}
