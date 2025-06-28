package com.example.payment_service_app;

import jakarta.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/payAmount")
    public String payAmount(@RequestBody PaymentDetails paymentDetails) {
        return paymentDetails.getFromUser() + " paid Amount : "  + paymentDetails.getAmount()
                + "  to " + paymentDetails.getToUser();
    }
}
