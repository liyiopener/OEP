package com.sut.oep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContro {
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
}
