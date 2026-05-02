package com.finsentinel.fraud.rules;

import com.finsentinel.model.FraudRule;
import com.finsentinel.model.Transaction;
import com.finsentinel.repository.FraudRuleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseRuleEvaluator implements FraudRuleEvaluator{
    private final FraudRuleRepository ruleRepository;

    @Override
    public double evaluate(Transaction tx){
        List<FraudRule> rules = ruleRepository.findByIsActiveTrue();

        double risk = 0;

        for (FraudRule rule: rules){
            String condition = rule.getConditionJson();

            if (condition.contains(tx.getMerchantCategory()))
                risk += rule.getRiskWeight();
        }

        return risk;
    }
}
