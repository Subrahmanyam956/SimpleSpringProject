package com.example.payment_service_app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaymentController {

    private final PaymentDetailsCheckService paymentDetailsCheckService;

    public PaymentController(PaymentDetailsCheckService paymentDetailsCheckService) {
        this.paymentDetailsCheckService = paymentDetailsCheckService;
    }


    @PostMapping("/payAmount")
    public ResponseEntity<Map<String, Object>> payAmount(@RequestBody PaymentDetails paymentDetails) {
        return paymentDetailsCheckService.checkPaymentUsers(paymentDetails);
    }
}
