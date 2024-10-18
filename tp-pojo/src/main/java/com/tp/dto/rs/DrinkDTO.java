package com.tp.dto.rs;

import lombok.Data;

@Data
public class DrinkDTO {
    private Long id;

    private String name;

    private String brand;

    private Double price;

    //0代表冰，1代表常温，2代表热
    private  Integer temperature;

    //0代表无糖，1代表少，2代表正常糖
//    private Integer sugar;
}

