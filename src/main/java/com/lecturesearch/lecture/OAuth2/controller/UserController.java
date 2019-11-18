package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> user = new ArrayList<User>();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "form";
    }

    @GetMapping(value = "/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        System.out.println("email : "+user.getEmail()+"  | name : "+user.getName());
        return "redirect:/main";
    }

    @PostMapping("/create")
    public String create(User user){
        // System.out.println("email : "+user.getEmail()+"  |  name : "+user.getName()+"  | password : "+user.getPassword
        // ());
        System.out.println("user : "+user);
        // user.add(user);
        // userRepository.save(user);

        return "redirect:/main";
    }

    @GetMapping("/userlist")
    public String list(){
        return "userlist";
    }

}

