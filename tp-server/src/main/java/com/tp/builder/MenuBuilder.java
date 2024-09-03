package com.tp.builder;


import com.tp.entity.rs.Drink;
import com.tp.entity.rs.Food;
import com.tp.entity.rs.Menu;
import com.tp.entity.rs.Snack;
import com.tp.mapper.rs.DrinkMapper;
import com.tp.mapper.rs.FoodMapper;
import com.tp.mapper.rs.SnackMapper;


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
