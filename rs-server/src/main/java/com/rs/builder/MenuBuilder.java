package com.rs.builder;


import com.rs.entity.Drink;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import com.rs.entity.Snack;
import com.rs.mapper.DrinkMapper;
import com.rs.mapper.FoodMapper;
import com.rs.mapper.SnackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class MenuBuilder {


private FoodMapper foodMapper;


private DrinkMapper drinkMapper;

private SnackMapper snackMapper;

    private Food food;
    private Drink drink;
    private Snack snack;

    public MenuBuilder(FoodMapper foodMapper,SnackMapper snackMapper,DrinkMapper drinkMapper){
        this.foodMapper=foodMapper;
        this.drinkMapper=drinkMapper;
        this.snackMapper=snackMapper;
    }
    public void buildFoodById(Long foodId){

        Food food=foodMapper.getById(foodId);
        this.food=food;
    }
    public void buildDrinkById(Long drinkId){
        Drink drink=drinkMapper.getById(drinkId);
        this.drink=drink;
    }
    public void buildSnackById(Long snackId){
        Snack snack=snackMapper.getById(snackId);
        this.snack=snack;
    }

    public void buildFoodByName(String foodName){
        Food food=foodMapper.getByName(foodName);
        this.food=food;
    }
    public void buildDrinkByName(String drinkName) {
        Drink drink=drinkMapper.getByName(drinkName);
        this.drink=drink;
    }
    public void buildSnackByName(String snackName){
        Snack snack=snackMapper.getByName(snackName);
        this.snack=snack;
    }
public void buildFood(Food food){
        this.food=food;
}

public void buildSnack(Snack snack){
        this.snack=snack;
}

public void buildDrink(Drink drink){
        this.drink=drink;
}
    public Menu buildMenu(){
        Menu menu=new Menu();
        menu.setDrink(drink);
        menu.setFood(food);
        menu.setSnack(snack);
        return menu;
    }
}
