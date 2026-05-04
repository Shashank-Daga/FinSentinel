package com.finsentinel.fraud;

import com.finsentinel.alert.FraudAlertService;
import com.finsentinel.fraud.decision.FraudDecision;
import com.finsentinel.fraud.decision.FraudDecisionEngine;
import com.finsentinel.fraud.scoring.RiskScoringService;
import com.finsentinel.model.Transaction;
import com.finsentinel.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final RiskScoringService riskScoringService;
    private final FraudDecisionEngine decisionEngine;
    private final TransactionRepository transactionRepository;
    private final FraudAlertService fraudAlertService;

    @Override
    @Transactional
    public Transaction analyzeTransaction(Transaction transaction){
        double riskScore = riskScoringService.calculateRisk(transaction);

        FraudDecision decision = decisionEngine.decide(riskScore);

        transaction.setRiskScore(riskScore);
        transaction.setStatus(decision.getStatus());

        if (decision.isFraud()){
            fraudAlertService.createAlert(
                    transaction,
                    decision.getType(),
                    decision.getReason(),
                    decision.getConfidence()
            );
        }

        return transactionRepository.save(transaction);
    }
}
