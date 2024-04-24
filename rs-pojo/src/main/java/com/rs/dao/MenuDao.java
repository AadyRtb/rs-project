package com.rs.dao;

import com.rs.entity.Drink;
import com.rs.entity.Food;
import com.rs.entity.Snack;
import lombok.Data;

@Data
public class MenuDao {
    private Long id;
    private String name;

    private Double  price;
    private Integer sell;
    private Integer status;

    private Long foodId;
    private Long drinkId;
    private Long snackId;
    private String brand;
}
