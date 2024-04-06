package com.rs.dto;

import com.rs.entity.Drink;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import com.rs.entity.Snack;

public class MenuDirector {
    private  MenuBuilder builder;

    public MenuDirector(MenuBuilder builder){
        this.builder=builder;
    }
    public Menu construct(Food food, Drink drink, Snack snack){
        builder.buildDrink(drink);
        builder.buildFood(food);
        builder.buildSnack(snack);
        return builder.buildMenu();
    }

}
