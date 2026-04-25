package com.finsentinel.repository;

import com.finsentinel.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long>{
}
