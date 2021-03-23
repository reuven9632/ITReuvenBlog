package com.ITReuvenBlog.WebBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoSurfController {

    @GetMapping("/go-surf")
    public String goSurf(Model model){
        return "go-surf";
    }
}
