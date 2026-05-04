package com.finsentinel.model;

import com.finsentinel.model.enums.AlertStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fraud_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlert extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    private String alertType;
    private String reason;
    private Double confidence;

    @Enumerated(EnumType.STRING)
    private AlertStatus status;
    private String priority;
    private String assignedTo;
    private String resolutionNotes;
}
