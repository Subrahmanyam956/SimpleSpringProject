package com.example.inventory_service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {

    private final RestTemplate restTemplate;
    private final Map<String, Object> inventory;
    private final String paymentUrl;

    public InventoryService(RestTemplate restTemplate,
                            @Qualifier("inventory") Map<String, Object> inventory,
                            @Value("payment_url") String paymentUrl) {
        this.restTemplate = restTemplate;
        this.inventory = inventory;
        this.paymentUrl = paymentUrl;
    }

    public Map<String, Object> getInventory() {
        return inventory;
    }

    public String makePayment(Map<String, Object> requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // HttpEntity with body and headers
        HttpEntity<Map> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(paymentUrl, requestEntity, String.class);
        return response.getBody();
    }
}
