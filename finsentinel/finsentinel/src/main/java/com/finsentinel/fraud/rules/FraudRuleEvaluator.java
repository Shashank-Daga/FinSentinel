package com.finsentinel.fraud.rules;

import com.finsentinel.model.Transaction;
public interface FraudRuleEvaluator {
    double evaluate(Transaction transaction);
}
