package com.finsentinel.fraud.behaviour;

import com.finsentinel.model.Transaction;

public interface BehaviourAnalysisService {
    double analyzeBehaviour(Transaction transaction);
}
