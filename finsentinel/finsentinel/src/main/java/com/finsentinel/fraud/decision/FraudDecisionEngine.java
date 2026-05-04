package com.finsentinel.fraud.decision;

public interface FraudDecisionEngine {
    FraudDecision decide(double riskScore);
}
