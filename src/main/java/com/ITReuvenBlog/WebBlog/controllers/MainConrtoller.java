package com.ITReuvenBlog.WebBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainConrtoller {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("welcome", "Welcome to ITReuven Blog");
        model.addAttribute("title", "ITReuven Blog");
        return "home";
    }

}