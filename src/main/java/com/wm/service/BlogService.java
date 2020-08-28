package com.wm.service;

import com.wm.po.Blog;
import com.wm.vo.BlogList;

import java.util.List;

public interface BlogService {

    List<BlogList> findAllBlogList();
    List<Blog> findAllBlog();

    Integer addBlog(Blog blog);

    Blog findById(Long id);
    Blog blogDetails(Long id);

    Integer updateById(Blog blog);
    Integer deleteById(Long id);

}
