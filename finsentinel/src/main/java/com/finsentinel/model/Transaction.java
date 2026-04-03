package com.finsentinel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double amount;
    private String location;
    private String deviceId;
    private String merchantCategory;
    private String transactionCategory;
    private String status;
    private Double riskScore;
    private LocalDateTime transactionTime = LocalDateTime.now();
}
