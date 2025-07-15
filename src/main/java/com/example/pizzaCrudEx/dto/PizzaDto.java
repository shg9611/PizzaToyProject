package com.example.pizzaCrudEx.dto;


import com.example.pizzaCrudEx.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PizzaDto {

    private Long id;
    private String name;
    private String price;

    public static PizzaDto createDto(Pizza pizza){

        return new PizzaDto(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice()
        );
    }
}
