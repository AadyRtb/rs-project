package com.tp.dto;

import lombok.Data;

@Data
public class CourseQueryDTO {

    private String name;
    private String major;
    private Integer type;

    private String sid;
    private Integer flag;
}
