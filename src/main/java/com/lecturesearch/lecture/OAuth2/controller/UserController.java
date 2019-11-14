package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "form";
    }

    @GetMapping(value = "/{facebook|google}/complete")
    public String loginComplete(@SocialUser User user) {
        System.out.println("email : "+user.getEmail()+" name : "+user.getName());
        return "redirect:/main";
    }

    @PostMapping("/create")
    public String create(@SocialUser User user){
        System.out.println("email : "+user.getEmail()+" name : "+user.getName());
        return "redirect:/main";
    }


}
