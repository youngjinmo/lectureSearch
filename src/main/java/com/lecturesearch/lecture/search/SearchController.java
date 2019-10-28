package com.lecturesearch.lecture.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("/save")
    public ResponseEntity<?> saveBoard(){
        //TEST DATA
        Board board = new Board((long)3,"는 정말 자바를 나 배워요2","객체지향에 관한 내용을 들을 수 있는 강의 입니다.",
               "자유",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                ,LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
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
    public ResponseEntity searchBoard(@RequestParam String titleAndContent){
        System.out.println(titleAndContent);
        List<Board> aa = searchService.searchTitle(titleAndContent);
        return new ResponseEntity(aa,HttpStatus.OK);
    }
}
