package com.akshata.aijira.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String predictPriority(String text) {

        text = text.toLowerCase();

        if (text.contains("security") ||
                text.contains("critical") ||
                text.contains("production") ||
                text.contains("urgent") ||
                text.contains("jwt") ||
                text.contains("authentication")) {
            return "HIGH";
        }

        if (text.contains("bug") ||
                text.contains("api") ||
                text.contains("integration") ||
                text.contains("fix")) {
            return "MEDIUM";
        }

        return "LOW";
    }
}