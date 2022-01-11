package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/makepayment")
    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findById(@PathVariable long orderId){
        return paymentService.findSpecificPayment(orderId);
    }

}
