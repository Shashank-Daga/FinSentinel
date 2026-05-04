package com.finsentinel.fraud.decision;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudDecision {
    private boolean fraud;
    private String status;
    private String type;
    private String reason;
    private double confidence;

    public boolean isFraud() {
        return fraud;
    }
}
