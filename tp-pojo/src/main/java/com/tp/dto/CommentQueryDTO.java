package com.tp.dto;

import lombok.Data;

@Data
public class CommentQueryDTO {
    private Integer cid;
    private String type;

    private Integer lbid;
}
