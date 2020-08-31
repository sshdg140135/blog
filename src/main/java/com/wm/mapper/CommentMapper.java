package com.wm.mapper;

import com.wm.po.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    List<Comment> findByBlogId(Long blogId);
    List<Comment> findByBlogIdAndParentIdNull(Long blogId);
    List<Comment> findByBlogIdAndParentIdNotNull(@Param("blogId") Long blogId, @Param("parentId") Long parentId);
    Comment findById(Long id);
    Integer insertComment(Comment comment);
}
