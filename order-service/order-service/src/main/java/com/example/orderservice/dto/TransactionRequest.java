package com.example.orderservice.dto;

import com.example.orderservice.dto.Payment;
import com.example.orderservice.model.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TransactionRequest {
    private final Order order;
    private final Payment payment;

}
