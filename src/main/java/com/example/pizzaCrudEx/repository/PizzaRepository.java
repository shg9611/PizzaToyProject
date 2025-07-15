package com.example.pizzaCrudEx.repository;

import com.example.pizzaCrudEx.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    @Override
    List<Pizza> findAll();
}
