package com.tp.entity.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drink extends Food {

    //0代表冰，1代表常温，2代表热
    private  Integer temperature;

    //0代表无糖，1代表少，2代表正常糖
    private Integer sugar;
}
