package com.example.pizzaCrudEx.service;

import com.example.pizzaCrudEx.dto.PizzaDto;
import com.example.pizzaCrudEx.entity.Pizza;
import com.example.pizzaCrudEx.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    public PizzaDto showOne(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id의 피자가 없습니다"));

        log.info(pizza.toString());
        return PizzaDto.createDto(pizza);

    }

    @Transactional
    public PizzaDto create(PizzaDto dto) {

        log.info(dto.toString());
        if (dto.getId()!=null){
            throw new IllegalArgumentException("피자 생성 실패. dto에 아이디 존재.");
        }
        Pizza pizza =dto.toPizza();
        log.info(pizza.toString());

        Pizza saved= pizzaRepository.save(pizza);
        log.info(saved.toString());

        return PizzaDto.createDto(saved);
    }

    @Transactional
    public PizzaDto update(Long id, PizzaDto dto) {

        log.info(dto.toString());

        Pizza target= pizzaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("피자 수정 실패. 해당 id의 피자 없음"));

        if (dto.getId()!=id){
            throw new IllegalArgumentException("피자 수정 실패. 잘못된 id 요청");
        }

        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);

        log.info(updated.toString());
        return PizzaDto.createDto(updated);
    }

    @Transactional
    public PizzaDto delete(Long id){

        Pizza target= pizzaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("피자 삭제 실패. 해당 id 피자 없음"));

        pizzaRepository.delete(target);

        return PizzaDto.createDto(target);
    }
}
