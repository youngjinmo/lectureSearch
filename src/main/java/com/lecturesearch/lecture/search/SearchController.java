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
    SearchService searchService;

    @Autowired
    ContentsService contentsService;

    @RequestMapping("/save")
    public ResponseEntity<?> saveBoard() {
        //TEST DATA
        Board board = new Board((long) 3, "는 정말 자바를 나 배워요2", "객체지향에 관한 내용을 들을 수 있는 강의 입니다.",
                "자유", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                , LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
        searchService.saveBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

//    @RequestMapping("/search/{title}")
//    public ResponseEntity searchBoard(@PathVariable String title){
//        List<Board> aa = searchService.searchTitle(title);
//        return new ResponseEntity(aa,HttpStatus.OK);
//    }

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
