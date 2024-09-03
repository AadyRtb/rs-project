package com.tp.vo;

import com.tp.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentQueryVO {
    private String userName;
    List<Comment> comments;
}
