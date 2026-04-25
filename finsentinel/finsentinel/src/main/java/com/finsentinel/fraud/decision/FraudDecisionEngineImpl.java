package com.finsentinel.fraud.decision;

import org.springframework.stereotype.Component;

@Component
public class FraudDecisionEngineImpl implements FraudDecisionEngine{

    @Override
    public String decide(double riskScore){
        if (riskScore >= 70)
            return "BLOCKED";

        if (riskScore >= 30)
            return "REVIEW";

        return "APPROVED";
    }
}
