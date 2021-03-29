package com.ITReuvenBlog.WebBlog.controllers;

import com.ITReuvenBlog.WebBlog.models.Role;
import com.ITReuvenBlog.WebBlog.models.User;
import com.ITReuvenBlog.WebBlog.repositoryes.UserRepository;
import com.ITReuvenBlog.WebBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {
    /*@Autowired
    private UserRepository userRepository;*/

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user /*автоматически вносит данные в класс User без @RequestParam и т.д.*/,
            /* @RequestParam String username, @RequestParam String password,*/ Model model){


        if (!userService.addUser(user)){
            model.addAttribute("message", "user exists");
            return "registration";
        }


        /*   --------------------------*/
        /*User user = userRepository.findByUsername(username);

        if (user != null){
            model.addAttribute("messageBool", true);
            model.addAttribute("message", "user exists!");
            return "registration";
        }

        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        model.addAttribute("message", "user add!");*/

        return "redirect:/login";
    }
}
