package com.lecturesearch.lecture;

import com.lecturesearch.lecture.OAuth2.annotation.SocialUser;
import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.repository.UserRepository;
import com.lecturesearch.lecture.contents.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ContentsService contentsService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/")
    public String main() {
        return "layout/main";
    }

    @RequestMapping(value = "/main")
    public String list(@PageableDefault Pageable pageable, Model model, HttpServletResponse response,
                       @SocialUser User socialUser, Principal principal) {
        Page i = contentsService.findContentsList(pageable);
        model.addAttribute("pageList", i);

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = (UserDetails)principal;

        // 로그인시 사용자이름 화면에서 출력
        User user =null;
        if(!(socialUser==null&&principal==null)) {
            if (socialUser == null) {
                user = userRepository.findByEmail(principal.getName()).get();
            } else {
                user = socialUser;
            }
            model.addAttribute("user", user);
        }
        response.setContentType("multipart/form-data");
        return "layout/main";
    }
}
