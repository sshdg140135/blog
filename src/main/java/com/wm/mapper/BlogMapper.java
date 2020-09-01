package com.wm.mapper;

import com.wm.po.Blog;
import com.wm.po.Tag;
import com.wm.po.Type;
import com.wm.vo.BlogList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogMapper {

    List<BlogList> findAllBlogList();
    List<Blog> findAllBlog();
    List<Blog> findPublishedBlog();
    Blog findById(Long id);
    List<Blog> findByType(Long id);
    List<Blog> searchByTitle(String title);
    List<String> findYear();
    List<Blog> findByYear(String year);
    Integer findBlogCount();
    Integer insertBlog(Blog blog);

    Integer updateBlog(Blog blog);
    Integer updateViews(Blog blog);

    Integer deleteById(Long id);
}
