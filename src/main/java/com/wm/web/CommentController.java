package com.wm.web;

import com.wm.po.Comment;
import com.wm.po.User;
import com.wm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public String comments(Long blogId, Model model) {
        List<Comment> comments = commentService.findListByBlogId(blogId);
        model.addAttribute("comments",comments);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String input(Comment comment, Model model, HttpSession session){
        Long blogId = comment.getBlog().getId();

        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar("/images/avatar.png");
            comment.setAdminComment(false);
        }
        System.out.println(comment);
        commentService.addComment(comment);
        return "redirect:/comments?blogId="+blogId ;
    }

}
