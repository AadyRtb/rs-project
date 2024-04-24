package com.rs.dto;
import lombok.Data;

@Data
public class MenuDTO {
    private  Long id;

    private String name;
    private Double price;

    private String brand;
    private String foodName;
    private String snackName;
    private String drinkName;

    private Integer sell;

}
