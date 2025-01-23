package com.example.payment_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/makePayment")
    public Map<String, Object> payForItems(@RequestBody Map<String, Object> requestPayload) {
//        String message = paymentService.makePayment(requestPayload);
        String message = "success";
        Map<String, Object> success = new HashMap<>();
        success.put("status", "success");
        success.put("message", message);
        return success;
    }

}
