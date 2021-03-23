package com.ITReuvenBlog.WebBlog.controllers;

import com.ITReuvenBlog.WebBlog.models.Post;
import com.ITReuvenBlog.WebBlog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ITReuvenBlog.WebBlog.repositoryes.PostRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String BlogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "ITReuvenBlog");
        return "blog";
    }

    @GetMapping("/blog/add")
    public String BlogAdd(Model model){
        model.addAttribute("title", "add blog");
        return "blog_add";
    }

    @PostMapping("/blog/add")
    public String BlogPostAdd(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text, user);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String BlogShowFullText(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }

        /*Optional<Post> optionalPost = postRepository.findById(id);
        ArrayList<Post> post = new ArrayList<>();
        optionalPost.ifPresent(post::add);*/

        Post post = postRepository.findById(id).orElseThrow();
        post.setViews(post.getViews() + 1);
        postRepository.save(post);

        model.addAttribute("post", post);
        model.addAttribute("title", "blog fullText");
        return "blog_show_full_text";
    }

    @GetMapping("/blog/{id}/edit")
    public String BlogEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        /*Post post = postRepository.findById(id).orElseThrow();*/

        Optional<Post> optionalPost = postRepository.findById(id);
        ArrayList<Post> post = new ArrayList<>();
        optionalPost.ifPresent(post::add);

        model.addAttribute("post", post);
        model.addAttribute("title", "edit blog");
        return "blog_edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String BlogUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}/delete")
    public String DeleteBlog(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        model.addAttribute("title", "edit blog");
        return "redirect:/blog";
    }

}
