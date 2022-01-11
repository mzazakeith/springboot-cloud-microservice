package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    private long id;
    private String paymentStatus;
    private String transactionId;
    private long orderId;
    private double amount;
}
