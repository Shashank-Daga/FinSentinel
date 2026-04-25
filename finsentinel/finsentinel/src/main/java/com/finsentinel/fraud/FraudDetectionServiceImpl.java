package com.finsentinel.fraud;

import com.finsentinel.fraud.decision.FraudDecisionEngine;
import com.finsentinel.fraud.scoring.RiskScoringService;
import com.finsentinel.model.Transaction;
import com.finsentinel.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final RiskScoringService riskScoringService;
    private final FraudDecisionEngine decisionEngine;
    private final TransactionRepository transactionRepository;

    @Override
    public void analyzeTransaction(Transaction transaction){
        double riskScore = riskScoringService.calculateRisk(transaction);

        String decision = decisionEngine.decide(riskScore);

        transaction.setRiskScore(riskScore);
        transaction.setStatus(decision);

        transactionRepository.save(transaction);
    }
}
