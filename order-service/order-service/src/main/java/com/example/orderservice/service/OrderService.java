package com.example.orderservice.service;

import com.example.orderservice.dto.Payment;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.dto.TransactionRequest;
import com.example.orderservice.dto.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    @Lazy
    private final RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response ="";
        Order order= request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice() * order.getQuantity());
//        Rest call
        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL,payment,Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"payment successfuly processed":"payment failed";
        orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
