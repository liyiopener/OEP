package com.sut.oep.controller;

import com.sut.oep.model.Comment;
import com.sut.oep.services.CommentService;
import com.sut.oep.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Comment")
public class CommentCtro {
    @Autowired
    private CommentService commentService;
    @PostMapping("addComment")
    public String addComment(HttpServletRequest request, @RequestParam("newcomment")String content,@RequestParam("commen_clsid") Integer classid,@RequestParam("commen_cid")Integer cid){
        HttpSession session = request.getSession();
        Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
        String time = TimeFormat.getTime();
        Comment comment = new Comment();
        comment.setClassid(classid);
        comment.setCid(cid);
        comment.setTime(time);
        comment.setUid(uid);
        comment.setContent(content);
        commentService.addComment(comment);
        return "redirect:/Course/toVideo?classid="+classid;
    }
    @GetMapping("/toComment")
    public ModelAndView toComment(HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
        List<Comment> comments = commentService.getAllCommentByUid(uid);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/comment");
        mv.addObject("comments",comments);
        return mv;
    }
    @GetMapping("/delComment")
    public String delComment(@RequestParam("commentid")Integer commentid){
        commentService.delCommentByKey(commentid);
        return "redirect:/Comment/toComment";
    }
}
