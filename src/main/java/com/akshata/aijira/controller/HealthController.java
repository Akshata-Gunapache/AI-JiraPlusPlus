package com.akshata.aijira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "AI Jira Backend is running on Google Cloud App Engine";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}