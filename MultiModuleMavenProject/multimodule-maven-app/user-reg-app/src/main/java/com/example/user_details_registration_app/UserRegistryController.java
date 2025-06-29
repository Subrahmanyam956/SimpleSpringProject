package com.example.user_details_registration_app;

import jakarta.ws.rs.QueryParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRegistryController {

    private final UserRegService userRegService;

    public UserRegistryController(UserRegService userRegService) {
        this.userRegService = userRegService;
    }

    @PostMapping("/register-user")
    public String registerUser(@RequestBody User user) {
        userRegService.addUser(user);
        return "successfully registered the user : " + user.getUserEmail();
    }

    @GetMapping("/check-user")
    public ResponseEntity<Map<String, Object>> checkRegisteredUser(@QueryParam("userEmail") String userEmail) {
        Map<String, Object> response = new HashMap<>();
        HttpStatus httpStatus = HttpStatus.OK;
        if(userRegService.isRegisteredUser(userEmail)) {
            response.put("isRegistered", true);
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
            response.put("isRegistered", false);
        }

        return new ResponseEntity<>(response, httpStatus);
    }

}
