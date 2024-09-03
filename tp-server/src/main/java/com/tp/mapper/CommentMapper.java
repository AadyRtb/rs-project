package com.tp.mapper;

import com.tp.dto.CommentDTO;
import com.tp.dto.CommentQueryDTO;
import com.tp.dto.ReplyDTO;
import com.tp.dto.UpvoteDTO;
import com.tp.entity.Comment;
import com.tp.entity.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getCommentList(CommentQueryDTO commentQueryDTO);

    @Select("select * from reply where comment_id = #{commentId} order by time asc")
    List<Reply> getReplyList(Long commentId);

    @Insert("insert into comment ( name, cid, content, time, lbid) values (#{name}, #{cid}, #{content}, #{time}, #{lbid})")
    void save(CommentDTO commentDTO);

    @Insert("insert into reply (fromname,toname, content,comment_id, time) values (#{fromName},#{toName}, #{content}, #{commentId}, #{time})")
    void addReply(ReplyDTO replyDTO);

    @Update("update comment set comment.like = comment.like + 1 where comment_id = #{id}")
    void commentUpvote(UpvoteDTO upvoteDTO);

    @Update("update reply set reply.like = reply.like + 1 where rid = #{id}")
    void replyUpvote(UpvoteDTO upvoteDTO);
}
