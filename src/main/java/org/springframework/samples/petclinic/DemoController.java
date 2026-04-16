package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    // 🔴 SQL Injection (very likely detected)
    @GetMapping("/user")
    public String getUser(@RequestParam String name) {
        String query = "SELECT * FROM users WHERE name = '" + name + "'";
        return query;
    }
}
