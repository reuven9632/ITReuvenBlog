package com.ITReuvenBlog.WebBlog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlonaNailsController {

    @GetMapping("/alona-nails")
    public String AlonaNails(Model model){
        return "alona-nails";
    }
}
