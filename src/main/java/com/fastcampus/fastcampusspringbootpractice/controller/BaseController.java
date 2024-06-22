package com.fastcampus.fastcampusspringbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String root() {
        //throw new Exception("테스트");
        return "index";
    }

}
