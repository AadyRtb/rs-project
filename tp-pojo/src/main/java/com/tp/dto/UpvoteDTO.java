package com.tp.dto;

import lombok.Data;

@Data
public class UpvoteDTO {
    Long id;
    Integer type;//0代表评论，1代表回复
}
