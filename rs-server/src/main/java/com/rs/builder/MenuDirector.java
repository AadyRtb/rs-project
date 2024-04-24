package com.rs.builder;

import com.rs.entity.Drink;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import com.rs.builder.MenuBuilder;
import com.rs.entity.Snack;


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
