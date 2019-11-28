package com.lecturesearch.lecture.admin;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    UserService userService;

    @RequestMapping("/usersData")
    public String showUserData(Model model){
        List<User> users=new ArrayList<>();
        users=userService.findAll();
        model.addAttribute("users",users);
        return "admin/basic_table";
    }
}
