package com.example.inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean("inventory")
	public Map<String, Object> inventory() {
		Map<String, Object> inventory = new HashMap<>();
		inventory.put("t-shirt", 500);
		inventory.put("mobile-charge", 200);
		return inventory;
	}
}
