package com.rs.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FoodDTO implements Serializable {
    protected Long id;

    protected String name;

    protected String brand;

    protected Double price;

}
