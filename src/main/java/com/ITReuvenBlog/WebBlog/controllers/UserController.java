package com.ITReuvenBlog.WebBlog.controllers;

import com.ITReuvenBlog.WebBlog.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/activate/{activationCode}")
    public String activateUser(@PathVariable String activationCode, Model model){
        boolean isActivated = userService.activateUser(activationCode);

        if (isActivated)
            model.addAttribute("message", "user succesfuly activated");
        else
            model.addAttribute("message", "activation code is not found");


        return "login";
    }

}
