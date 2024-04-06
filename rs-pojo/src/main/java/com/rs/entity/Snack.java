package com.rs.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snack extends Food{

    //0代表不加酱料，1代表番茄酱，2代表黑椒酱
    private Integer sause;
}
