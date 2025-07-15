package com.example.pizzaCrudEx.entity;

import com.example.pizzaCrudEx.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;


    public void patch(PizzaDto dto) {
        if (dto.getName()!=null){
            this.name=dto.getName();
        }
        if (dto.getPrice()!=null){
            this.name=dto.getPrice();
        }
    }
}
