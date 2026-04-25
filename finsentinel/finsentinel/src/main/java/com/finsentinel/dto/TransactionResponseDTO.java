package com.finsentinel.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TransactionResponseDTO {
    private Long transactionId;
    private String status;
    private Double riskScore;
}
