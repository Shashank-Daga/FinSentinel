package com.finsentinel.alert;

import com.finsentinel.model.FraudAlert;
import com.finsentinel.model.Transaction;

import java.util.List;

public interface FraudAlertService {
    FraudAlert createAlert(Transaction tx, String type, String reason, double confidence);

    List<FraudAlert> getOpenAlerts();

    FraudAlert assignAlert(Long alertId, String investigator);

    FraudAlert updateStatus(Long alertId, String status);
}
