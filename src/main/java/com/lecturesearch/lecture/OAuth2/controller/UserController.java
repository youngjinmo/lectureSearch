package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.password.PasswordEncoding;
import com.lecturesearch.lecture.OAuth2.repository.UserRepository;
import com.lecturesearch.lecture.OAuth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        // 비밀번호 암호화
        PasswordEncoding passwordEncoding = new PasswordEncoding();
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoding.encode(rawPassword);
        user.setPassword(encodedPassword);

        user.setCreatedDate();

        userService.saveUser(user);

        return "redirect:/login";
    }

    @GetMapping("/userlist")
    public String list(){
        return "userlist";
    }

}

