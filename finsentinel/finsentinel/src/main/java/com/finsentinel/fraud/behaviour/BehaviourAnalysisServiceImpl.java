package com.finsentinel.fraud.behaviour;

import com.finsentinel.model.Transaction;
import com.finsentinel.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BehaviourAnalysisServiceImpl implements BehaviourAnalysisService{
    private final TransactionRepository transactionRepository;

    @Override
    public double analyzeBehaviour(Transaction tx){
        double risk = 0;

        List<Transaction> history = transactionRepository.findByUser(tx.getUser());

        // New Device Detection
        boolean knownDevice = history.stream()
                .anyMatch(t ->
                    tx.getDeviceId().equals(t.getDeviceId()));

        if (!knownDevice)
            risk += 25;

        // Velocity Check
        LocalDateTime fiveMinuteAgo = tx.getTransactionTime().minusMinutes(5);

        long recentTransactions = history.stream()
                .filter(t -> t.getCreatedAt().isAfter(fiveMinuteAgo)).count();

        if (recentTransactions > 5)
            risk += 30;

        // Location Anomaly
        boolean newLocation = history.stream()
                .noneMatch(t -> tx.getLocation().equalsIgnoreCase(t.getLocation()));

        if (newLocation)
            risk += 20;

        return risk;
    }
}
