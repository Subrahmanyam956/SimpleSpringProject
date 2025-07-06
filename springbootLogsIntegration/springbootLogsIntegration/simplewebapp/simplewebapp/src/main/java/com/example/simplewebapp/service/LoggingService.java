package com.example.simplewebapp.service;


import com.example.simplewebapp.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);

    @Value("${noOfTimes.repeat.user}")
    private int noOfTimesRepeatUser;

    public boolean registerUser(User user) {
        try {
            for(int i = 0; i < noOfTimesRepeatUser; i++) {
                LOGGER.info("Registered user: {}", user.toString());
            }

            return true;
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while registering the user :  ", exception);
        }
        return false;
    }
}
