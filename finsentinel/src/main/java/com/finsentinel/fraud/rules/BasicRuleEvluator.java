package com.finsentinel.fraud.rules;

import com.finsentinel.model.Transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BasicRuleEvluator implements FraudRuleEvaluator{

    @Override
    public double evaluate(Transaction tx){
        double risk = 0;

        // Rule 1: High Amount
        if (tx.getAmount() > 50000)
            risk += 40;

        // Rule 2: Risky Merchant
        if ("Gambling".equalsIgnoreCase(tx.getMerchantCategory()))
            risk += 30;

        // Rule 3:International Location
        if (!"India".equalsIgnoreCase(tx.getLocation()))
            risk += 20;

        log.info("Rule Risk Score: {}", risk);

        return risk;
    }
}
