package com.tp.service.impl;

import com.tp.builder.MenuBuilder;
import com.tp.builder.MenuDirector;
import com.tp.dto.rs.MenuDTO;
import com.tp.entity.rs.Drink;
import com.tp.entity.rs.Food;
import com.tp.entity.rs.Menu;
import com.tp.mapper.rs.DrinkMapper;
import com.tp.mapper.rs.FoodMapper;
import com.tp.mapper.rs.MenuMapper;
import com.tp.mapper.rs.SnackMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuServiceImplTest {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private DrinkMapper drinkMapper;
    @Autowired
    private SnackMapper snackMapper;
    @Test
    void getById() {
        Long id =1L;
        MenuDTO menuDTO= menuMapper.getById(id);
        MenuBuilder builder=new MenuBuilder(foodMapper,snackMapper,drinkMapper);
        MenuDirector director=new MenuDirector(builder);
        Menu menu=null;

        Assertions.assertNull(menu);

        menu=director.constructByName(menuDTO.getFoodName(), menuDTO.getSnackName(), menuDTO.getDrinkName());
        menu.setPrice(menuDTO.getPrice());
        menu.setName(menuDTO.getName());
        menu.setBrand(menuDTO.getBrand());
        menu.setId(menuDTO.getId())  ;
        menu.setStatus(1);
        menu.setSell(menuDTO.getSell());

        Food food=foodMapper.getById(1L);
        Drink drink=drinkMapper.getById(1L);

        Assertions.assertNotNull(menu);

        Assertions.assertEquals(menu.getFood(),food);

        Assertions.assertFalse(menu.getDrink()==drink, "为假");

        Assertions.assertTrue(menu.getDrink().getId()==drink.getId(), "为真");
    }
}