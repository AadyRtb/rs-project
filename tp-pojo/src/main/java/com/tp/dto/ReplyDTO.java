package com.tp.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReplyDTO implements Serializable {
    String fromName;
    String content;
    LocalDateTime time;
    String toName;
    Long commentId;
}
