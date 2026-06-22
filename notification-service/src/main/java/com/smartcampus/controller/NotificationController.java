package com.smartcampus.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping
    public String send(@RequestBody String message) {

        System.out.println("📩 NOTIFICATION RECEIVED: " + message);

        return "Notification sent!";
    }
}