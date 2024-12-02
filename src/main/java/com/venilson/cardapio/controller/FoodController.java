package com.venilson.cardapio.controller;

import com.venilson.cardapio.food.Food;
import com.venilson.cardapio.food.FoodRepository;
import com.venilson.cardapio.food.FoodRequestDTO;
import com.venilson.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return foodRepository.findAll().stream()
                .map(FoodResponseDTO::new).toList();
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodRepository.save(foodData);
    }
}
