package com.wm.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.NotFoundException;
import com.wm.po.Blog;
import com.wm.po.Type;
import com.wm.service.BlogService;
import com.wm.service.TagService;
import com.wm.service.TypeService;
import com.wm.vo.BlogList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String indexPage(@RequestParam(defaultValue="1",value="pageNum") Integer pageNum,
                            Model model){
        //查询全部博客、分类、推荐...并传递到前台
        PageHelper.startPage(pageNum, 2);
        List<Blog> blogs = blogService.findAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);

        List<Type> types = typeService.findAllTypes();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", types);
        return "index";
    }

    @GetMapping("/blog")
    public String blogPage(Long id, Model model){
        Blog blog = blogService.blogDetails(id);
//        blog.setViews(blog.getViews()+1);

        model.addAttribute("blog", blog);
        return "blog";
    }

}
