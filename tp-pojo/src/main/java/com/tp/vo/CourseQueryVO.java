package com.tp.vo;

import lombok.Data;

@Data
public class CourseQueryVO {

    private int cid;
    private String name;
    private String describe;
    private Float credit;
    private Integer type;//课程类型 0：必修 1：选修

    private Integer state; //课程状态 1:未修读 2:已修读

}
