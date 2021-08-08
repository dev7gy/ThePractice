package com.example.eatgo.interfaces;

import com.example.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String Hello() {
        return "Hello, World";
    }
}
