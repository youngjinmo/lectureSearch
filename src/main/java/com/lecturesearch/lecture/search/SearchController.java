package com.lecturesearch.lecture.search;

import com.lecturesearch.lecture.contents.ContentsService;
import com.lecturesearch.lecture.contents.ContentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("")
public class SearchController {
    private static String saveTitle;

    @Autowired
    ContentsService contentsService;

    @RequestMapping("/search")
    public String searchContents(@RequestParam String title, @PageableDefault Pageable pageable, Model model) {
        saveTitle = title;
        Page<ContentsVO> resultPage = contentsService.searchTitle(title, pageable);
        model.addAttribute("resultList", resultPage);
        return "layout/main";
    }

    @RequestMapping("/searchResult")
    public String searchResult(@PageableDefault Pageable pageable, Model model) {
        Page<ContentsVO> resultPage = contentsService.searchTitle(saveTitle, pageable);
        model.addAttribute("resultList", resultPage);
        return "layout/main";
    }
}
