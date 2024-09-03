package com.tp.vo;

import lombok.Data;

@Data
public class LbQueryVO {
    private Integer cid;
    private String name;
    private String describe;
    private Float credit;
    private String type;
    private Integer state; //课程状态 1:未修读 2:已修读
}
