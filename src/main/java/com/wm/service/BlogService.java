package com.wm.service;

import com.wm.po.Blog;
import com.wm.vo.BlogList;

import java.util.List;

public interface BlogService {

    List<BlogList> findAllBlogList();
    List<Blog> findAllBlog();
    List<Blog> findPublishedBlog();
    List<Blog> findByType(Long id);
    List<Blog> searchByTitle(String title);

    Integer addBlog(Blog blog);

    Blog findById(Long id);
    Blog blogDetails(Long id);

    Integer updateById(Blog blog);
    Integer updateViews(Blog blog);

    Integer deleteById(Long id);

}
