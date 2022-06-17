package com.example.minitest.controller;

import com.example.minitest.model.Posts;
import com.example.minitest.service.IPostService;
import com.example.minitest.service.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
//@RequestMapping("/posts")
@Controller
public class PostController {
    @Autowired
    ServicePost servicePost;

    @GetMapping("/home")
    public String home(){
        return "/index";
    }
    @GetMapping("/posts")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("posts",servicePost.findAll());
        return modelAndView;
    }

    @GetMapping("/create-post")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }
    @PostMapping("/create-post")
    public ModelAndView save(@ModelAttribute("post") Posts post){
        ModelAndView modelAndView = new ModelAndView("/create");//redirect:/province
        servicePost.save(post);
        modelAndView.addObject("province",new Posts());
        modelAndView.addObject("message","New province created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable("id")Long id){
        Optional<Posts> province = servicePost.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("posts",province.get());
        return modelAndView;
    }
    @PostMapping("/edit-post")
    public ModelAndView updatePost(@ModelAttribute("post") Posts posts){
        servicePost.save(posts);
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");//redirect:/province
        return modelAndView;
    }

    @GetMapping("/search-post")
    public ModelAndView search(@RequestParam("title") String search){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Posts> posts = servicePost.findAllByTitleContaining(search);
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }
    @GetMapping("/findTop4")
    public ModelAndView findTop4(){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Posts> posts = servicePost.findTop4();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }
    @GetMapping("/findLike")
    public ModelAndView findLikes(){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Posts> posts = servicePost.findAllByLikesAsc();
        modelAndView.addObject("posts",posts);
        return modelAndView;
    }



    @GetMapping("/delete-posts/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id){
        Optional<Posts> province = servicePost.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("province",province.get());
        return modelAndView;
    }
    @PostMapping("/delete-posts")
    public ModelAndView remote(@ModelAttribute("province") Posts posts){
        servicePost.remove(posts.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        return modelAndView;
    }

}
