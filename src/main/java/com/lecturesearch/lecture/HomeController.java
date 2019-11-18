package com.lecturesearch.lecture;

import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.contents.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ContentsService contentsService;

//    @RequestMapping("/")
//    public String main(Model model, @ModelAttribute ContentsVO paramVO) {
//        Iterable<ContentsVO> rsList = contentsService.contentsList();
//        model.addAttribute("list", rsList);
//        return "/layout/main";
//    }

    @GetMapping("/")
    public String home(){
        return "main";
    }

    @RequestMapping("/main")
    public String list(@PageableDefault Pageable pageable, Model model, HttpServletResponse response, @SocialUser User user) {
        Page i = contentsService.findContentsList(pageable);
        model.addAttribute("pageList", i);
        response.setContentType("multipart/form-data");
        model.addAttribute("user", user); // 로그인시 메뉴에서 이름 출력 by 영진
        return "/layout/main";
    }
}
