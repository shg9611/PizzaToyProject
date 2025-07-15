package com.example.pizzaCrudEx.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @GetMapping("/api")
    public String pizza(){
        return "hello";
    }
}
