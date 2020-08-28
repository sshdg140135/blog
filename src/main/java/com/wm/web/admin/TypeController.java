package com.wm.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.po.Type;
import com.wm.service.TypeService;
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
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(defaultValue="1",value="pageNum")Integer pageNum,
                        Model model){
        Integer pageSize = 2;
        List<Type> types = typeService.listType(pageNum, pageSize);
        //使用PageInfo包装查询后的结果
        PageInfo<Type> page = new PageInfo<>(types,pageSize);
        model.addAttribute("page", page);
        return "admin/types";
    }

    @GetMapping("/types/update")
    public String updatePage(Long id, Model model){
        model.addAttribute("type", typeService.findById(id));
        return "admin/types-input";
    }

    @GetMapping("/types/input")
    public String inputPage(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @PostMapping("/types/input")
    public String inputType(Type type, RedirectAttributes attributes){

        Integer i = typeService.addType(type);

        if (i>0){
            attributes.addFlashAttribute("message", "添加分类成功");
        } else {
            attributes.addFlashAttribute("message", "添加分类失败");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/update")
    public String update(Type type, RedirectAttributes attributes){
        Integer i = typeService.editById(type);

        if (i>0){
            attributes.addFlashAttribute("message", "更新分类成功");
        } else {
            attributes.addFlashAttribute("message", "更新分类失败");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/delete")
    public String deleteType(Long id, RedirectAttributes attributes){
        Integer i = typeService.deleteById(id);

        if (i>0){
            attributes.addFlashAttribute("message", "删除分类成功");
        } else {
            attributes.addFlashAttribute("message", "删除分类失败");
        }
        return "redirect:/admin/types";
    }
}
