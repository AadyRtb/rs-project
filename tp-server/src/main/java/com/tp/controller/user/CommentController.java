package com.tp.controller.user;

import com.tp.dto.CommentDTO;
import com.tp.dto.CommentQueryDTO;
import com.tp.dto.ReplyDTO;
import com.tp.dto.UpvoteDTO;
import com.tp.entity.Comment;
import com.tp.result.Result;
import com.tp.service.CommentService;
import com.tp.vo.CommentQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/comment")
@Slf4j
@Api(tags= "评论相关接口")
public class CommentController{
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    @ApiOperation("获取评论列表")
    public Result<CommentQueryVO> getCommentList(CommentQueryDTO commentQueryDTO){
        CommentQueryVO commentQueryVO = commentService.getCommentList(commentQueryDTO);
        return Result.success(commentQueryVO);

    }


    @PostMapping()
    @ApiOperation("添加评论")
    public Result save(@RequestBody CommentDTO commentDTO){
        commentService.save(commentDTO);

        return  Result.success();
    }

    @PostMapping("/reply")
    @ApiOperation("添加回复")
    public Result addReply(@RequestBody ReplyDTO ReplyDTO) {
        commentService.addReply(ReplyDTO);
        return Result.success();
    }

    @PutMapping("/upvote")
    @ApiOperation("点赞")
    public Result upvote(@RequestBody UpvoteDTO upvoteDTO) {
        commentService.upvote(upvoteDTO);
        return Result.success();
    }
}
