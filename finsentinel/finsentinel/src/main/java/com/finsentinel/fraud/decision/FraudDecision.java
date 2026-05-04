package com.finsentinel.fraud.decision;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class FraudDecision {

    @Getter
    private boolean fraud;
    private String status;
    private String type;
    private String reason;
    private double confidence;
}
