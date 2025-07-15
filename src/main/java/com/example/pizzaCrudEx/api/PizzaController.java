package com.example.pizzaCrudEx.api;

import com.example.pizzaCrudEx.dto.PizzaDto;
import com.example.pizzaCrudEx.entity.Pizza;
import com.example.pizzaCrudEx.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDto> showOne(@PathVariable Long id){
        PizzaDto pizzaDto = pizzaService.showOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(pizzaDto);
    }

    @PostMapping("/api/pizza")
    public ResponseEntity<PizzaDto> create(@RequestBody PizzaDto dto){

        PizzaDto created = pizzaService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @PatchMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable Long id, @RequestBody PizzaDto dto){

        PizzaDto updated = pizzaService.update(id,dto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);

    }

    @DeleteMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long id){
        PizzaDto deleted = pizzaService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);

    }


}
