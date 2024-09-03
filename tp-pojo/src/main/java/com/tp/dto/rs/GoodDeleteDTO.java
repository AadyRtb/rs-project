package com.tp.dto.rs;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodDeleteDTO implements Serializable {
    private String goodName;
    private String goodBrand;

}
