package com.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO implements Serializable {
    private String name;
    private String content;
    private LocalDateTime time;
    private Integer lbid;
    private Integer cid;
}
