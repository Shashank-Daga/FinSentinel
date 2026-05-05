package com.finsentinel.event;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudEvent {
    private Long transactionID;
    private String userId;
    private Double amount;
    private String decision;
    private Double riskscore;
    private long timestamp;
}
