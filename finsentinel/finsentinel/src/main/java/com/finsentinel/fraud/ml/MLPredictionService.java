package com.finsentinel.fraud.ml;

import com.finsentinel.model.Transaction;

public interface MLPredictionService {
    double getFraudProbability(Transaction transaction);
}
