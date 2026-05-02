package com.finsentinel.fraud.adaptive;

import com.finsentinel.model.FraudRule;
import com.finsentinel.model.Transaction;
import com.finsentinel.repository.FraudRuleRepository;
import com.finsentinel.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdaptiveRuleServiceImpl implements AdaptiveRuleService{

    private final TransactionRepository transactionRepository;
    private final FraudRuleRepository fraudRuleRepository;

    @Override
    public void analyzeAndGenerateRules(){
        List<Transaction> riskyTransactions = transactionRepository.findAll().stream()
                .filter(t -> t.getRiskScore() != null && t.getRiskScore() > 80).toList();

        riskyTransactions.stream().map(Transaction::getMerchantCategory).distinct()
                .forEach(category -> {
                    FraudRule rule = FraudRule.builder()
                            .ruleName("AUTO_RULE_" + category)
                            .conditionJson(category)
                            .riskWeight(25.0)
                            .isActive(true)
                            .createdBy("AI Engine")
                            .build();

                    fraudRuleRepository.save(rule);
                });
    }
}
