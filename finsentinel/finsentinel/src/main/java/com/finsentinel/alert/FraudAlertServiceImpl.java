package com.finsentinel.alert;

import com.finsentinel.model.FraudAlert;
import com.finsentinel.model.Transaction;
import com.finsentinel.model.enums.AlertStatus;
import com.finsentinel.repository.FraudAlertRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FraudAlertServiceImpl implements FraudAlertService{
    private final FraudAlertRepository alertRepository;

    @Override
    public FraudAlert createAlert(Transaction tx, String type, String reason, double confidence){
        FraudAlert alert = FraudAlert.builder()
                .transaction(tx)
                .alertType(type)
                .reason(reason)
                .confidence(confidence)
                .status(AlertStatus.OPEN)
                .priority(resolvePriority(confidence))
                .build();

        return alertRepository.save(alert);
    }

    private String resolvePriority(double confidence){
        if (confidence > 0.9) return "HIGH";
        if (confidence > 0.7) return "MEDIUM";
        return "LOW";
    }

    @Override
    public List<FraudAlert> getOpenAlerts(){
        return alertRepository.findByStatus(AlertStatus.OPEN);
    }

    @Override
    public FraudAlert assignAlert(Long alertId, String investigator){
        FraudAlert alert = alertRepository.findById(alertId).orElseThrow();

        alert.setAssignedTo(investigator);
        alert.setStatus(AlertStatus.UNDER_REVIEW);

        return alertRepository.save(alert);
    }

    @Override
    public FraudAlert updateStatus(Long alertId, String status){
        FraudAlert alert = alertRepository.findById(alertId).orElseThrow();

        alert.setStatus(AlertStatus.valueOf(status));

        return alertRepository.save(alert);
    }
}
