package com.tp.service.impl;

import com.tp.context.BaseContext;
import com.tp.dto.*;
import com.tp.entity.Comment;
import com.tp.entity.Reply;
import com.tp.mapper.CommentMapper;
import com.tp.mapper.StudentMapper;
import com.tp.service.CommentService;
import com.tp.vo.CommentQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public CommentQueryVO getCommentList(CommentQueryDTO commentQueryDTO) {
        String userName = studentMapper.getById(BaseContext.getCurrentId()).getName();
        List<Comment> commentList = commentMapper.getCommentList(commentQueryDTO);

        // 获取回复
        for (Comment comment : commentList) {
            ReplyQueryDTO replyQueryDTO = getReplyList(comment.getCommentId());
            comment.setReplyList(replyQueryDTO.getReplyList());
            comment.setReplyNum(replyQueryDTO.getReplyNum());
        }

        CommentQueryVO commentQueryVO = new CommentQueryVO();
        commentQueryVO.setComments(commentList);
        commentQueryVO.setUserName(userName);
        return commentQueryVO;

    }

    @Override
    public ReplyQueryDTO getReplyList(Long commentId) {
        List<Reply> replyList = commentMapper.getReplyList(commentId);
        Integer replyNum=replyList.size();
        ReplyQueryDTO replyQueryDTO = new ReplyQueryDTO();
        replyQueryDTO.setReplyList(replyList);
        replyQueryDTO.setReplyNum(replyNum);
        return replyQueryDTO;
    }

    @Override
    public void save(CommentDTO commentDTO) {
        commentMapper.save(commentDTO);
    }

    @Override
    public void addReply(ReplyDTO replyDTO) {
        commentMapper.addReply(replyDTO);
    }

    @Override
    public void upvote(UpvoteDTO upvoteDTO) {
        if(upvoteDTO.getType()==0)
            commentMapper.commentUpvote(upvoteDTO);
        else if(upvoteDTO.getType()==1)
            commentMapper.replyUpvote(upvoteDTO);
    }


}
