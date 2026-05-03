package com.finsentinel.fraud;

import com.finsentinel.model.Transaction;

public interface FraudDetectionService {
    Transaction analyzeTransaction(Transaction transaction);
}
