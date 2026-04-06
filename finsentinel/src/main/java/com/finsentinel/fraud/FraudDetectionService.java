package com.finsentinel.fraud;

import com.finsentinel.model.Transaction;

public interface FraudDetectionService {
    void analyzeTransaction(Transaction transaction);
}
