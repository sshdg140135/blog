package com.wm.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wm.po.Blog;
import com.wm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ArchivesController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public String achives(Model model){
        model.addAttribute("archiveMap", blogService.findArchives());
        model.addAttribute("blogCount", blogService.findBlogCount());
        return "archives";
    }
}
