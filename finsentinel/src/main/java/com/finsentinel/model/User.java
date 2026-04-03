package com.finsentinel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity{
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String accountNumber;
}
