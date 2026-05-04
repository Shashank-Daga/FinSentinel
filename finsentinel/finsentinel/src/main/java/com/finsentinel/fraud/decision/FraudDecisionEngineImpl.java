package com.finsentinel.fraud.decision;

import org.springframework.stereotype.Component;

@Component
public class FraudDecisionEngineImpl implements FraudDecisionEngine{

    @Override
    public FraudDecision decide(double riskScore){
        if (riskScore >= 70) {
            return new FraudDecision(
                    true,
                    "BLOCKED",
                    "HIGH_RISK",
                    "High fraud probability",
                    riskScore
            );
        }

        if (riskScore >= 30) {
            return new FraudDecision(
                    true,
                    "REVIEW",
                    "MEDIUM_RISK",
                    "Suspicious Behaviour",
                    riskScore
            );
        }

        return new FraudDecision(
                false,
                "APPROVED",
                "LOW_RISK",
                "Normal transaction",
                riskScore
        );
    }
}
