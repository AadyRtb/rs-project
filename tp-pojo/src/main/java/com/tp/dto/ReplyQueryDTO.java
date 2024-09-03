package com.tp.dto;

import com.tp.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyQueryDTO {
    private Integer replyNum;
    private List<Reply> replyList;
}
