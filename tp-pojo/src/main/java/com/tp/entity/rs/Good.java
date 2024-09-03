package com.tp.entity.rs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Good implements Serializable{

    protected Long id;

    protected String name;

    protected Double  price;
    protected Integer sell;
    protected String brand;
    protected Integer status;
}
