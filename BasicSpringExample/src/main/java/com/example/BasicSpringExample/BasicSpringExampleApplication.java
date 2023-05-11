package com.example.BasicSpringExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicSpringExampleApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BasicSpringExampleApplication.class, args);
		
	}
	
	
	@Bean
	public Employee employee() {
		return new Employee("Subrahmanyam", "Martha");
	}

}
