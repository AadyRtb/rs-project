package com.tp.service;

import com.tp.dto.*;
import com.tp.vo.CommentQueryVO;

public interface CommentService {
    CommentQueryVO getCommentList(CommentQueryDTO commentQueryDTO);

    ReplyQueryDTO getReplyList(Long commentId);

    void save(CommentDTO commentDTO);

    void addReply(ReplyDTO replyDTO);

    void upvote(UpvoteDTO upvoteDTO);
}
