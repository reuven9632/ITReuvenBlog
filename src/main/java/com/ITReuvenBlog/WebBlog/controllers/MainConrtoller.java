package com.ITReuvenBlog.WebBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainConrtoller {

    @GetMapping("/")
    public String stringHome(Model model) {
        model.addAttribute("welcome", "Welcome to ITReuven Blog");
        model.addAttribute("title", "ITReuven Blog");
        return "index";
    }

    @GetMapping("/about")
    public String aboutHome(Model model) {
        model.addAttribute("welcome", "Welcome to \"about\" ITReuven Blog");
        model.addAttribute("title", "ITReuven about");
        return "about";
    }

}