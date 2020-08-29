package com.wm.service;

import com.wm.NotFoundException;
import com.wm.mapper.BlogMapper;
import com.wm.po.Blog;
import com.wm.util.MarkdownUtils;
import com.wm.vo.BlogList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<BlogList> findAllBlogList() {
        return blogMapper.findAllBlogList();
    }

    @Override
    public List<Blog> findAllBlog() {

        return blogMapper.findAllBlog();
    }

    @Override
    public List<Blog> findPublishedBlog() {
        return blogMapper.findPublishedBlog();
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return blogMapper.searchByTitle(title);
    }


    @Override
    public Integer addBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public Blog findById(Long id) {

        return blogMapper.findById(id);
    }

    @Override
    public Blog blogDetails(Long id) {
        Blog blog = blogMapper.findById(id);
        if (blog == null){
            new NotFoundException("博客不存在");
        }
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    @Override
    public Integer updateById(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Integer updateViews(Blog blog) {

        return blogMapper.updateViews(blog);
    }

    @Override
    public Integer deleteById(Long id) {

        return blogMapper.deleteById(id);
    }
}
