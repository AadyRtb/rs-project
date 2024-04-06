package com.rs.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SnackDTO extends FoodDTO {

    protected Long id;

    protected String name;

    protected String brand;

    protected Double price;

    //0代表不加酱料，1代表番茄酱，2代表黑椒酱
    private Integer sause;


}
