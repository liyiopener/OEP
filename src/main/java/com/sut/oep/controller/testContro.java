package com.sut.oep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class testContro {
    @RequestMapping("/testImg")
    public String testImg(){
        return "user/testImg";
    }
    @RequestMapping("/testVedio")
    public String testVedio(){
        return "course/coursePlay";
    }

}
