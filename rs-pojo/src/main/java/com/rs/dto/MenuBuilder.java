package com.rs.dto;


import com.rs.entity.Drink;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import com.rs.entity.Snack;

public class MenuBuilder {
    private Food food;
    private Drink drink;
    private Snack snack;
    public void buildFood(Food food){
        this.food=food;
    }
    public void buildDrink(Drink drink){
        this.drink=drink;
    }
    public void buildSnack(Snack snack){
        this.snack=snack;
    }

    public Menu buildMenu(){
        Menu menu=new Menu();
        menu.setDrink(drink);
        menu.setFood(food);
        menu.setSnack(snack);
        menu.setPrice(snack.getPrice()+ food.getPrice()+ drink.getPrice());
        menu.setSell(0);
        menu.setStatus(0);
        return menu;
    }
}
