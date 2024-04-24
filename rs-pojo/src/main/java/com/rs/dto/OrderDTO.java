package com.rs.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {
    //0代表主食，1代表小吃，2代表饮品，3代表套餐
    private Integer type;

    private Long goodId;

}
