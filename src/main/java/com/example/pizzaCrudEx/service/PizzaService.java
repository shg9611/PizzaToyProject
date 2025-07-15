package com.example.pizzaCrudEx.service;

import com.example.pizzaCrudEx.dto.PizzaDto;
import com.example.pizzaCrudEx.entity.Pizza;
import com.example.pizzaCrudEx.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaDto> show() {
        List<Pizza> pizzaList=pizzaRepository.findAll();

        List<PizzaDto> pizzaDtoList = pizzaList.stream()
                .map((pizza)->PizzaDto.createDto(pizza))
                .collect(Collectors.toList());

        return pizzaDtoList;
    }
}
