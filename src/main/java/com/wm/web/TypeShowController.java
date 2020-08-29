package com.wm.web;

import com.wm.po.Blog;
import com.wm.po.Type;
import com.wm.service.BlogService;
import com.wm.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;


    @GetMapping("/types")
    public String typesPage(
                            @RequestParam(defaultValue="-1")Long id,
                            Model model){
        List<Blog> blogs;
        if (id == -1){
            //说明从首页进入未点击标签查询
            blogs = blogService.findAllBlog();
        }else {
            blogs = blogService.findByType(id);
        }
        List<Type> types = typeService.findAllTypes();
        model.addAttribute("activeTypeId", id);
        model.addAttribute("blogs", blogs);
        model.addAttribute("types", types);
        return "types";
    }

}
