package com.tp.service.rs;

import com.tp.dto.rs.DrinkDTO;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.rs.Drink;
import com.tp.result.PageResult;

public interface DrinkService {
    void save(DrinkDTO drinkDTO);

    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    Drink getById(Long id);
    Drink getByName(String name);

    void delete(Long id);

    void update(DrinkDTO drinkDTO);
}
