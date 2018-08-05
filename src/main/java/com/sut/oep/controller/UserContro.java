package com.sut.oep.controller;

import com.sut.oep.model.Choose;
import com.sut.oep.model.Course;
import com.sut.oep.model.User;
import com.sut.oep.services.ChooseService;
import com.sut.oep.services.UserService;
import com.sut.oep.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserContro {
    @Autowired
    private UserService userService;
    @Autowired
    private ChooseService chooseService;
    //用户信息
    @RequestMapping("/to_userInfo")
    public String to_user_index(){
        return "user/userInfo";
    }
    @RequestMapping("/to_comment")
    public String to_comment(){
        return "user/comment";
    }
    @RequestMapping("/to_tuCourse")
    public String to_tuCourse(HttpServletRequest request){
        HttpSession session = request.getSession();
        String uid = session.getAttribute("uid").toString();
        User user = userService.getUserInfo(uid);
        if(user.getRole()==0)
            return "user/uCourse";
        else return "user/tuCourse";
    }
    @ResponseBody
    @GetMapping("/getUCourses")
    public List<Course> getUCourses(HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
        List<Course> courses = chooseService.getCourses(uid);
        for (Course course:courses)
            System.out.println(course);
        return courses;
    }
    @RequestMapping("/changeImg")
    public String changeImg(@RequestParam("test") MultipartFile file){
        FileUpload fileUpload = new FileUpload();
        fileUpload.UploadOne(file);
        return "user/userIndex";
    }
    @ResponseBody
    @RequestMapping("/userInfo")
    public User userInfo(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String uid = session.getAttribute("uid").toString();
        User user = userService.getUserInfo(uid);
        return user;
    }
    @PostMapping("/update_user")
    public String test(User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
        user.setUid(uid);
        userService.updateUser(user);
        return "user/userIndex";
    }
}
