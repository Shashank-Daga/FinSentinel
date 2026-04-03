package com.finsentinel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fraud_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudRule extends BaseEntity{
    private String ruleName;

    @Column(columnDefinition = "TEXT")
    private String conditionJson;

    private Double riskWeight;
    private Boolean isActive;
    private String createdBy;
}
