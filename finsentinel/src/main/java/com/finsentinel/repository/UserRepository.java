package com.finsentinel.repository;

import com.finsentinel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByAccountNumber(String AccountNumber);
}
