package com.finsentinel.fraud.scoring;

import com.finsentinel.fraud.behaviour.BehaviourAnalysisService;
import com.finsentinel.fraud.ml.MLPredictionService;
import com.finsentinel.fraud.rules.FraudRuleEvaluator;
import com.finsentinel.model.Transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiskScoringServiceImpl implements RiskScoringService {
//    private final FraudRuleEvaluator ruleEvaluator;

    private final List<FraudRuleEvaluator> evaluators;
    private final MLPredictionService mlPredictionService;
    private final BehaviourAnalysisService behaviourAnalysisService;

    @Override
    public double calculateRisk(Transaction transaction){
        double ruleRisk = evaluators.stream()
                .mapToDouble(e -> e.evaluate(transaction)).sum();

        // Placeholder ML risk (future model)
        double mlRisk = mlPredictionService.getFraudProbability(transaction) * 100;

        double behaviourRisk = behaviourAnalysisService.analyzeBehaviour(transaction);

        return ruleRisk + mlRisk + behaviourRisk;
    }
}
