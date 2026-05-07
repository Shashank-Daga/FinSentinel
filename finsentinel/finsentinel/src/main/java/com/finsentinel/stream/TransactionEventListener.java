package com.finsentinel.stream;

import com.finsentinel.fraud.FraudDetectionService;
import com.finsentinel.model.Transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionEventListener {
    private final FraudDetectionService fraudDetectionService;

    @EventListener
    public void handleTransaction(Transaction transaction){
        fraudDetectionService.analyzeTransaction(transaction);
    }
}
