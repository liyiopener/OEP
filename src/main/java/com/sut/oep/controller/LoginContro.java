package com.sut.oep.controller;

import com.sut.oep.model.User;
import com.sut.oep.services.MailService;
import com.sut.oep.services.UserService;
import com.sut.oep.util.IdentiCode;
import com.sut.oep.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class LoginContro {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    //跳转注册页面
    @RequestMapping(value = "/to_sign_up")
    public String to_sign_up(){
        return "login/sign_up";
    }
    //注册
    @RequestMapping(value = "/sign_up")
    public String sign_up(HttpServletRequest request,User user){
        user.setCreateTime(TimeFormat.getTime());
        userService.signUp(user);
        String nick = user.getNickname().toString();
        String uid = user.getUid().toString();
        HttpSession session = request.getSession();
        session.setAttribute("nick",nick);
        session.setAttribute("uid",uid);
        return "index";
    }
    //验证邮箱是否已经注册过
    @ResponseBody
    @RequestMapping(value = "/isEmailExist")
    public Boolean isEmailExist(@RequestParam(value = "email")String email){
        return userService.isEmailExist(email);
    }
    //验证昵称是否注册
    @ResponseBody
    @PostMapping(value = "/isNickNameExist")
    public Boolean isNickNamelExist(@RequestParam(value = "nickname") String nickname){
        //System.out.print(nickname);
        return userService.isNickNameExist(nickname);
    }
    //发送验证码
    @ResponseBody
    @RequestMapping("/sent_code")
    public String sentCode(@RequestParam("email") String email,HttpServletRequest request){
        String idencode= IdentiCode.createVerificationCode(6);
        System.out.println(idencode);
        mailService.activeAcc(idencode,email);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("idencode",idencode);
        return "验证码发送成功!";
    }
    //校验验证码
    @ResponseBody
    @RequestMapping("/testIdentCode")
    public boolean testIdentCode(HttpServletRequest httpServletRequest,@RequestParam("identcode")String identcode){
        HttpSession httpSession = httpServletRequest.getSession();
        String identcodes = httpSession.getAttribute("idencode").toString();
        return identcode.equals(identcodes);
    }

    //跳转登陆页面
    @RequestMapping("/to_sign_in")
    public String to_sign_in(){
        return "login/sign_in";
    }
    //登陆
    @RequestMapping(value = "/sign_in",method = RequestMethod.POST)
    public String test_name(HttpServletRequest request,User user){
        user.setEmail(user.getNickname());
        user= userService.isUserExist(user);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("nick",user.getNickname());
            session.setAttribute("uid",user.getUid());
            session.setAttribute("role",user.getRole());
            return "index";
        }
        else{
            request.setAttribute("warm","用户名或密码错误");
            return "login/sign_in";
        }
    }
    //注销
    @RequestMapping("/sign_off")
    public String sign_off(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("uid");
        session.removeAttribute("nick");
        return "index";
    }
}
