package com.example.pizzaCrudEx.api;

import com.example.pizzaCrudEx.dto.PizzaDto;
import com.example.pizzaCrudEx.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/api/pizza")
    public ResponseEntity<List<PizzaDto>> show(){

        List<PizzaDto> pizzaDtoList = pizzaService.show();

        return ResponseEntity.status(HttpStatus.OK).body(pizzaDtoList);

    }
}
