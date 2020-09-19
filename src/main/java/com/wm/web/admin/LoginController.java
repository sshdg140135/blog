package com.wm.web.admin;

import com.wm.po.User;
import com.wm.service.UserService;
import com.wm.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    @PostMapping("/login2")
    public String login2(User user, RedirectAttributes attributes){
        //MD5加密
        user.setPassword(MD5Utils.code(user.getPassword()));

        // 1、获取subject
        Subject subject = SecurityUtils.getSubject();
        // 2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 3、执行登录方法
        try {
            subject.login(token);
            // 登录成功
            return "admin/index";
        } catch (UnknownAccountException e) {
            // 一旦有异常就是登录失败
            // UnknownAccountException用户名不存在异常
            attributes.addFlashAttribute("message", "用户名不存在");
            return "redirect:/admin";

        } catch (IncorrectCredentialsException e){
            //  密码错误异常
            attributes.addFlashAttribute("message", "密码错误");
            return "redirect:/admin";
        }


    }



}
