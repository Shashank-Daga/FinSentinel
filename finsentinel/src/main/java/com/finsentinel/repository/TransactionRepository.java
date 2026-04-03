package com.finsentinel.repository;

import com.finsentinel.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
}
