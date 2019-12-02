package com.lecturesearch.lecture.OAuth2.controller;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        User loginUser = userService.findByEmail(user.getEmail()).get();
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

        System.out.println(user);

        return "redirect:/login";
    }

    // 회원가입시 이메일 중복체크
    @RequestMapping(value="/emailChk", method = RequestMethod.POST)
    public @ResponseBody boolean postIdCheck(@RequestParam("email") String email) {
        boolean result = true;
        if(userService.findByEmail(email).isPresent()){
            result = false;
        }
        return result;
    }

}

