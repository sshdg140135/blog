package com.wm.web.admin;

import com.github.pagehelper.PageInfo;
import com.wm.po.Tag;
import com.wm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tags(@RequestParam(defaultValue="1",value="pageNum")Integer pageNum,
                        Model model){
        Integer pageSize = 2;
        List<Tag> tags = tagService.listTag(pageNum, pageSize);
        //使用PageInfo包装查询后的结果
        PageInfo<Tag> page = new PageInfo<>(tags,pageSize);
        model.addAttribute("page", page);
        return "admin/tags";
    }

    @GetMapping("/tags/update")
    public String updatePage(Long id, Model model){
        model.addAttribute("tag", tagService.findById(id));
        return "admin/tags-input";
    }

    @GetMapping("/tags/input")
    public String inputPage(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tags/input")
    public String inputTag(Tag tag, RedirectAttributes attributes){

        Integer i = tagService.addTag(tag);

        if (i>0){
            attributes.addFlashAttribute("message", "添加标签成功");
        } else {
            attributes.addFlashAttribute("message", "添加标签失败");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/update")
    public String update(Tag tag, RedirectAttributes attributes){
        Integer i = tagService.editById(tag);

        if (i>0){
            attributes.addFlashAttribute("message", "更新标签成功");
        } else {
            attributes.addFlashAttribute("message", "更新标签失败");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/delete")
    public String deleteTag(Long id, RedirectAttributes attributes){
        Integer i = tagService.deleteById(id);

        if (i>0){
            attributes.addFlashAttribute("message", "删除标签成功");
        } else {
            attributes.addFlashAttribute("message", "删除标签失败");
        }
        return "redirect:/admin/tags";
    }

}
