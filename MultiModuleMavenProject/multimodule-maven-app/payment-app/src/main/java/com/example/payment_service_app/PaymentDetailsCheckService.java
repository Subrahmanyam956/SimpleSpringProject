package com.example.payment_service_app;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentDetailsCheckService {

    private final RestTemplate restTemplate;

    public PaymentDetailsCheckService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<Map<String, Object>> checkPaymentUsers(PaymentDetails paymentDetails) {

        Map<String, Object> response = new HashMap<>();

        String fromUserEmail = paymentDetails.getFromUser();
        String toUserEmail = paymentDetails.getToUser();
        if(!checkUserRegistration(fromUserEmail) ||
                !checkUserRegistration(toUserEmail)) {
            response.put("status", "Invalid Payment");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public boolean checkUserRegistration(String userEmail) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String url = "http://user-details-registration-app/check-user?userEmail=" + userEmail;
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                new ParameterizedTypeReference<Map<String, Object>>() {});

        Map<String, Object> responseBody = response.getBody();
        assert responseBody != null;
        return (boolean) responseBody.getOrDefault("isRegisteredUser", false);
    }
}
