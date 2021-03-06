package com.ITReuvenBlog.WebBlog.controllers;

import com.ITReuvenBlog.WebBlog.models.Message;
import com.ITReuvenBlog.WebBlog.repositoryes.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/message")
    public String MainMessage(Model model){
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("message", messages);
        return "message";
    }

    @PostMapping("/message/add")
    public String AddMessage(@RequestParam String text, @RequestParam String tag, Model model){
        Message message = new Message(text, tag);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("message", messages);
        return "message";
    }

    @GetMapping("/message/{id}/delete")
    public  String DeleteMessage(@PathVariable(value = "id") long id, Model model){
        if (messageRepository.existsById(id)) {
            Message message = messageRepository.findById(id).orElseThrow();
            messageRepository.delete(message);
        }
        else{
            model.addAttribute("error", "you do`nt have message id=" + id);
        }
        return "redirect:/message";
    }
}
