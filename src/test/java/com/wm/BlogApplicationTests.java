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
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
        List<String> years = blogMapper.findYear();
        Map<String, List<Blog>> map = new LinkedHashMap<>();
        for (String year : years) {
            map.put(year, blogMapper.findByYear(year));
        }
        System.out.println(map);

    }

}
