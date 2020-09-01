package com.wm.service;

import com.wm.po.Blog;
import com.wm.vo.BlogList;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<BlogList> findAllBlogList();
    List<Blog> findAllBlog();
    List<Blog> findPublishedBlog();
    List<Blog> findByType(Long id);
    List<Blog> searchByTitle(String title);
    Map<String, List<Blog>> findArchives();
    Integer findBlogCount();
    Integer addBlog(Blog blog);

    Blog findById(Long id);
    Blog blogDetails(Long id);

    Integer updateById(Blog blog);
    Integer updateViews(Blog blog);

    Integer deleteById(Long id);

}
