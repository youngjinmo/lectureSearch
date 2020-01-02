package com.lecturesearch.lecture.admin;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.service.UserService;
import com.lecturesearch.lecture.contents.ContentsService;
import com.lecturesearch.lecture.contents.ContentsVO;
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

    @Autowired
    ContentsService contentsService;

    @RequestMapping("/usersData")
    public String showUserData(Model model) {
        List<User> users;
        users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/user_table";
    }

    @RequestMapping("/lectureData")
    public String showLectureDate(Model model) {
        List<ContentsVO> contents;
        contents = contentsService.findAll();
        model.addAttribute("contents", contents);
        return "admin/lectures_table";
    }

    @RequestMapping("/deleteContent")
    public String deleteContent(String idx) {
        contentsService.deleteContent(idx);
        return "redirect:lectureData";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String idx) {
        userService.deleteUser(idx);
        return "redirect:usersData";
    }

}
