package com.rs.service;

import com.rs.dto.DrinkDTO;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Drink;
import com.rs.result.PageResult;

public interface DrinkService {
    void save(DrinkDTO drinkDTO);

    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    Drink getById(Long id);
    Drink getByName(String name);

    void delete(Long id);

    void update(DrinkDTO drinkDTO);
}
