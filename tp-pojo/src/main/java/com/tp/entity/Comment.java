package com.tp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements Serializable {
    private Long commentId;
    private String name;
    private Integer cid;
    private String content;
    private LocalDateTime time;
    private Integer like;
    private Integer replyNum;

    private List<Reply> replyList;

    private Boolean inputShow=false;//是否显示回复框

}
