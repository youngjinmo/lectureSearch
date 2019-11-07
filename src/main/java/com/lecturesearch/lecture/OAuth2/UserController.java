package com.lecturesearch.lecture.OAuth2;

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

    @GetMapping(value = "/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        System.out.println(user.getEmail());
        return "redirect:/main";
    }

    @GetMapping("/create")
    public String create(String userEmail, String userPassword){
        System.out.println("email : "+userEmail+" password : "+userPassword);
        return "layout/main";
    }

}
