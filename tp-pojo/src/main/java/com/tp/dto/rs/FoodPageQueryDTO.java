package com.tp.dto.rs;

import lombok.Data;

import java.io.Serializable;

@Data
public class FoodPageQueryDTO implements Serializable {

    //商品名称
    private String name;

    //商品品牌
    private String brand;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;
}
