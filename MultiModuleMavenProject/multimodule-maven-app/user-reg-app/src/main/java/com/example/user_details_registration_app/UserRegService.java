package com.example.user_details_registration_app;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRegService {

    int id = 1;
    Map<String, Object> userMap = new HashMap<>();

    public void addUser(User user) {
        user.setId(id++);
        userMap.put(user.getUserEmail(), user);
    }


    public boolean isRegisteredUser(String userEmail) {
        return userMap.containsKey(userEmail);
    }

}
