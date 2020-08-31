package com.wm.service;

import com.wm.mapper.CommentMapper;
import com.wm.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    List<Comment> tempReplys = new ArrayList<>();
    @Override
    public List<Comment> findListByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentMapper.findByBlogIdAndParentIdNull(blogId);
        for(Comment comment : comments){
            Long id = comment.getId();
            String nickname = comment.getNickname();
            List<Comment> childComments = commentMapper.findByBlogIdAndParentIdNotNull(blogId,id);
//            查询出子评论
            findReplyComments(childComments, nickname);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }


    public void findReplyComments(List<Comment> comments, String parentNickname) {
//        判断是否有一级子评论
        if(comments.size() > 0){
//                循环找出子评论的id
            for(Comment comment : comments){
                comment.getParentComment().setNickname(parentNickname);
                tempReplys.add(comment);
//                    查询出子二级评论
                recursively(comment);
            }
        }
    }
    private void recursively(Comment comment) {
        Long blogId = comment.getBlog().getId();
        Long id = comment.getId();
        String nickName  = comment.getNickname();
        List<Comment> replayComments = commentMapper.findByBlogIdAndParentIdNotNull(blogId,id);
        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                /*设置父节点的昵称*/
                replayComment.getParentComment().setNickname(nickName);
                tempReplys.add(replayComment);
                recursively(replayComment);
            }
        }
    }

    @Override
    public List<Comment> findParentComments(Long blogId) {
        return commentMapper.findByBlogIdAndParentIdNull(blogId);
    }
    @Override
    public Integer addComment(Comment comment) {
        if (comment.getParentComment().getId() == -1){
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentMapper.insertComment(comment);
    }
    @Override
    public List<Comment> findByBlogId(Long blogId) {
        return commentMapper.findByBlogId(blogId);
    }

}
