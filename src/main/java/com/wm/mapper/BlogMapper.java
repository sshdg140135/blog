package com.wm.mapper;

import com.wm.po.Blog;
import com.wm.po.Tag;
import com.wm.vo.BlogList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogMapper {

    List<BlogList> findAllBlogList();
    List<Blog> findAllBlog();
    Integer insertBlog(Blog blog);
    Blog findById(Long id);

    Integer updateBlog(Blog blog);

    Integer deleteById(Long id);
}
