package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.password.PasswordEncoding;
import com.lecturesearch.lecture.OAuth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "form";
    }

    @GetMapping(value = "/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        User loginUser = userService.findByEmail(user.getEmail());
        loginUser.setLastVisitDate();
        loginUser.countVisitNum();
        userService.saveUser(loginUser);
        return "redirect:/main";
    }

    @PostMapping("/create")
    public String create(User user){

        user.setEncodePassword(user.getPassword());

        user.setCreatedDate();
        user.setLastVisitDate();

        userService.saveUser(user);

        return "redirect:/login";
    }

}

