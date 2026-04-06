package com.finsentinel.fraud.decision;

public interface FraudDecisionEngine {
    String decide(double riskScore);
}
