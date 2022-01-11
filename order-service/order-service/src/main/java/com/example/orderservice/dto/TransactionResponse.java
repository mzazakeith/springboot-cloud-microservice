package com.example.orderservice.dto;

import com.example.orderservice.model.Order;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    private Order order;
    private double amount;
    private String transactionId;
    private String message;


}
