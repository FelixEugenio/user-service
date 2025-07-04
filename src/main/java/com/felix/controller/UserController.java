package com.felix.controller;

import com.felix.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();
        user.setFullName("Mariano Manuel");
        user.setEmail("mariano@gmail.com");
        user.setPhone("+351929374017");
        user.setRole("admin");
        return user;
    }
}
