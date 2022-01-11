package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.dto.TransactionRequest;
import com.example.orderservice.dto.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/bookorder")
    public TransactionResponse saveOrder(@RequestBody TransactionRequest request){
        return orderService.saveOrder(request);
    }

}
