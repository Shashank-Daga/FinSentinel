package com.finsentinel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDevice extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String deviceId;
    private LocalDateTime lastUsed = LocalDateTime.now();
}
