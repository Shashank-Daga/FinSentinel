package com.finsentinel.repository;

import com.finsentinel.model.FraudAlert;
import com.finsentinel.model.enums.AlertStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long>{
    List<FraudAlert> findByStatus(AlertStatus status);
    List<FraudAlert> findByAssignedTo(String investigator);
}
