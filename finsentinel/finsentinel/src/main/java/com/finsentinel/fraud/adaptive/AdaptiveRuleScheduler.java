package com.finsentinel.fraud.adaptive;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdaptiveRuleScheduler {
    private final AdaptiveRuleService adaptiveRuleService;

    @Scheduled(fixedRate = 300000)
    public void learnFromFraud(){
        adaptiveRuleService.analyzeAndGenerateRules();
    }
}
