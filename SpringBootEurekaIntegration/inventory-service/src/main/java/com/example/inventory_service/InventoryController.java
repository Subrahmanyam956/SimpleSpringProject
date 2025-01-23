package com.example.inventory_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/getItems")
    public Map<String, Object> getInventory() {
       return inventoryService.getInventory();
    }

    @PostMapping("/pay")
    public Map<String, Object> payForItems(@RequestBody  Map<String, Object> requestPayload) {
        String message = inventoryService.makePayment(requestPayload);
        Map<String, Object> success = new HashMap<>();
        success.put("status", "success");
        success.put("message", message);
        return success;
    }
}
