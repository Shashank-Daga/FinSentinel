package com.finsentinel.fraud.scoring;

import com.finsentinel.model.Transaction;
public interface RiskScoringService {
    double calculateRisk(Transaction transaction);
}
