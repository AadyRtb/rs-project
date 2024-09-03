package com.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String major;

    private  Float totalCredit;
    private Float needCredit;
    private String password;

    private String realName;
    private String clazz;
}
