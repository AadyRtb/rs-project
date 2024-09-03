package com.tp.builder;

import com.tp.entity.rs.Drink;
import com.tp.entity.rs.Food;
import com.tp.entity.rs.Menu;
import com.tp.entity.rs.Snack;


public class MenuDirector {

    private MenuBuilder builder;

    public MenuDirector(MenuBuilder builder){
        this.builder=builder;
    }
    public Menu constructById(Long food,Long snack,Long drink){
        builder.buildDrinkById(drink);
        builder.buildFoodById(food);
        builder.buildSnackById(snack);
        return builder.buildMenu();
    }

    public Menu constructByName(String food,String snack,String drink){
        builder.buildDrinkByName(drink);
        builder.buildFoodByName(food);
        builder.buildSnackByName(snack);
        return builder.buildMenu();
    }

    public Menu construct(Food food, Snack snack, Drink drink){
        builder.buildFood(food);
        builder.buildSnack(snack);
        builder.buildDrink(drink);
        return builder.buildMenu();
    }
}
