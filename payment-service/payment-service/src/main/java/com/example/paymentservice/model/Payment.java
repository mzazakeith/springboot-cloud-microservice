package com.example.paymentservice.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String paymentStatus;
    private String transactionId;
    private long orderId;
    private double amount;
}
