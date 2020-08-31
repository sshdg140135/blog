package com.wm.web.admin;

import com.wm.po.User;
import com.wm.service.UserService;
import com.wm.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "admin/login";
    }
    @GetMapping
    public String loginPage2(){
        return "admin/login";
    }


    @PostMapping("/login")
    public String login(User user, HttpSession session,
                        RedirectAttributes attributes){
        user.setPassword(MD5Utils.code(user.getPassword()));
        User loginUser = userService.login(user);
        if (loginUser != null){
            loginUser.setPassword(null);
            session.setAttribute("user", loginUser);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
