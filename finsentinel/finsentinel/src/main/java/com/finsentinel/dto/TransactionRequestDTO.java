package com.finsentinel.dto;

import lombok.Data;

@Data
public class TransactionRequestDTO {
    private String accountNumber;
    private Double amount;
    private String location;
    private String deviceId;
    private String merchantCategory;
    private String transactionType;

    private String ipAddress;
    private String deviceType;
}
