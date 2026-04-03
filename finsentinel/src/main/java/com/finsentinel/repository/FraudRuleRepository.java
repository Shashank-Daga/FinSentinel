package com.finsentinel.repository;

import com.finsentinel.model.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudRuleRepository extends JpaRepository<FraudRule, Long>{
    List<FraudRule> findByIsActiveTrue();
}
