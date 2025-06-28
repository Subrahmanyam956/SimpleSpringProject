package com.example.user_details_registration_app;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistryController {

    public String registerUser(@RequestBody User user) {
        return "successfully registered the user : " + user.getUserEmail();
    }
}
