package com.wm;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.mapper.BlogMapper;
import com.wm.po.Blog;
import com.wm.po.Type;
import com.wm.service.BlogService;
import com.wm.service.TypeService;
import com.wm.util.MarkdownUtils;
import com.wm.vo.BlogList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    BlogService blogService;
    @Test
    void contextLoads() {


        Blog blog = blogService.findById((long) 5);
        String content = blog.getContent();
        System.out.println(MarkdownUtils.markdownToHtmlExtensions(content));
    }

}
