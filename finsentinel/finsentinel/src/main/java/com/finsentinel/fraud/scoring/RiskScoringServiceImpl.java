package com.finsentinel.fraud.scoring;

import com.finsentinel.fraud.ml.MLPredictionService;
import com.finsentinel.fraud.rules.FraudRuleEvaluator;
import com.finsentinel.model.Transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiskScoringServiceImpl implements RiskScoringService {
    private final FraudRuleEvaluator ruleEvaluator;
    private final MLPredictionService mlPredictionService;

    @Override
    public double calculateRisk(Transaction transaction){
        double ruleRisk = ruleEvaluator.evaluate(transaction);

        // Placeholder ML risk (future model)
        double mlRisk = mlPredictionService.getFraudProbability(transaction) * 100;

        return ruleRisk + mlRisk;
    }
}
