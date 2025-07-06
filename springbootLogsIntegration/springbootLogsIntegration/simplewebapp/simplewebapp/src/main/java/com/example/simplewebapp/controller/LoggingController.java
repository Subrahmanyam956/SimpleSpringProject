package com.example.simplewebapp.controller;

import com.example.simplewebapp.dto.User;
import com.example.simplewebapp.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    private final LoggingService loggingService;

    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }


    @PostMapping("/register-user")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String message = "successfully registered user";
        HttpStatus status = HttpStatus.OK;
        if(!loggingService.registerUser(user)) {
            message = "exception when registering the user";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(message, status);
    }
}
