package com.practice.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class WelcomeController {

    @GetMapping("/welcome")
    public String getGreeting(){
        return "Welcome to WestWorld";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/postGreeting")
    public String postGreeting() {
        return "Thank you";
    }
}
