package com.upgrad.ImageHoster.controller;

import com.google.common.hash.Hashing;
import com.upgrad.ImageHoster.form.RegisterNewUser;
import com.upgrad.ImageHoster.model.Post;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.PostService;
import com.upgrad.ImageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class UserController1 {

    @Autowired
    PostService postservice;

    @Autowired
    UserService userService;

    @RequestMapping("/users/login")
    public String loginPage(){
        return "../users/login";
    }

    @RequestMapping(value="/users/login", method = RequestMethod.POST)
    public String login(RegisterNewUser registerNewUser ,Model model){
       // boolean validuser = true;
        if(userService.authenticate(registerNewUser.getUserName(),registerNewUser.getPasswordHash())){
            return "redirect:/posts";
        }
        return "redirect:/";
    }
    @RequestMapping("/users/logout")
    public String logOut(Model model){
        List<Post> list = postservice.firstThreePosts();
        model.addAttribute("posts",list);
        return "index";

    }

    @RequestMapping("/users/register")
    public String register(RegisterNewUser registerNewUser){
        return "../users/register";
    }

    @RequestMapping(value = "/users/register",method = RequestMethod.POST)
    public String registerUser(RegisterNewUser registerNewUser){
        User user = new User(registerNewUser.getFullName(),registerNewUser.getFullName());
        String sha256hex;
        sha256hex = Hashing.sha256()
                .hashString(registerNewUser.getPasswordHash(), StandardCharsets.UTF_8)
                .toString();
        user.setPasswordHash(sha256hex);
        userService.registerNewUser(user);
        return "redirect:/";
    }


}