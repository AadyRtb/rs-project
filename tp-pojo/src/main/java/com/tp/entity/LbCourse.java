package com.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LbCourse {
    private Integer cid;
    private String name;
    private String describe;
    private Float credit;
    private String type;
}
