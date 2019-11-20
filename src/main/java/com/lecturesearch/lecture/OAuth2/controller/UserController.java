package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.password.PasswordEncoding;
import com.lecturesearch.lecture.OAuth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
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
        // 비밀번호 암호화
        PasswordEncoding passwordEncoding = new PasswordEncoding();
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoding.encode(rawPassword);
        user.setPassword(encodedPassword);

        // user 정보 콘솔 출력
        System.out.println("user : "+user);

        return "redirect:/main";
    }

    @GetMapping("/userlist")
    public String list(){
        return "userlist";
    }

}

