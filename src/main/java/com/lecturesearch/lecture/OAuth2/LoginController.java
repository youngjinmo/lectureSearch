package com.lecturesearch.lecture.OAuth2;

import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        System.out.println(user.getEmail());
        return "redirect:/main";
    }
}
