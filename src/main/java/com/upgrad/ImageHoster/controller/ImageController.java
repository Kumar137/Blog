package com.upgrad.ImageHoster.controller;
import com.upgrad.ImageHoster.model.Post;
import com.upgrad.ImageHoster.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model)
    {
        List<Post> list=postService.firstThreePosts();
        model.addAttribute("posts",list);
        return "index";
    }
}
