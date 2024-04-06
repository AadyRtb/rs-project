package com.rs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Good implements Serializable{

    protected Long id;

    protected String name;

    protected Double  price;
    protected Integer sell;
    protected Integer status;
}
