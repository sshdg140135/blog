package com.wm;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.mapper.BlogMapper;
import com.wm.mapper.CommentMapper;
import com.wm.po.Blog;
import com.wm.po.Comment;
import com.wm.po.Type;
import com.wm.service.BlogService;
import com.wm.service.CommentService;
import com.wm.service.TypeService;
import com.wm.util.MarkdownUtils;
import com.wm.vo.BlogList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
        List<Comment> comments = commentService.findListByBlogId((long) 5);
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

}
