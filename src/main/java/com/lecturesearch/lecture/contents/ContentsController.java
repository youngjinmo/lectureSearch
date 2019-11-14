package com.lecturesearch.lecture.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/contents")
public class ContentsController {

    @Autowired
    private ContentsService contentsService;

//    @RequestMapping("/list")
//    public String list(Model model, @ModelAttribute ContentsVO paramVO){
//        Iterable<ContentsVO> rsList = contentsService.contentsList(paramVO);
//        model.addAttribute("list", rsList);
//        return "layout/main";
//    }

    @RequestMapping("/detail")
    public String detailView(String idx, Model model, @PageableDefault Pageable pageable) {
        ContentsVO i = contentsService.detailView(idx);
        Page r = contentsService.findReviewList(idx, pageable);
        model.addAttribute("contents", i);
        model.addAttribute("review", r);
        return "/contents/detailView";
    }

//    @RequestMapping("/insert")
//    public String write() {
//        //임시 데이터저장용
//        for(int i = 0; i < 30; i++){
//            ContentsVO paramVO = new ContentsVO("양념가득 치킨"+i, "인프런","파이썬","img_4.jpg",55000,"파이썬은 문법 구조가 쉽기 때문에 프로그래밍을 처음 접하는 초보자도 쉽게 이해할 수 있어요. 파이썬은 그 어떤 프로그래밍 언어보다 확장성이 월등히 높은 언어에요. 데이터분석가도, 웹개발자도, 머신러닝 연구자도, 대학원생도 파이썬을 사용하죠. 당신이 어떤 업무를 맡더라도 파이썬만 알아두면 척척 대응하기 쉬워집니다.\n" +
//                    "\n" +
//                    "당연히 비전공자도 다룰 수 있습니다. 프로그래밍 언어는 만국공통어에요. 만약 C, Java 등의 언어를 접해봤다면 더욱 쉽게 파이썬을 익힐 수 있겠죠.\n" +
//                    "\n" +
//                    "파이썬의 기본부터 심화까지 차근차근 따라해보세요. 인프런이 제시하는 프로그래밍 학습 로드맵을 따라가면 어느덧 파이썬 프로그래밍을 마스터한 자신과 만나게 될 겁니다. ","2019년 7월 16일","12시간 39분", LocalDateTime.now().toString());
//            contentsService.insert(paramVO);
//        }
//     return "redirect:/main";
//    }


    @RequestMapping("/boardform")
    public String boardForm() {
        return "/layout/boardForm";
    }
    @RequestMapping("/review")
    public String reviewWrite(@ModelAttribute ReviewVO paramVO, Model model, String contentsIdx) {
        contentsService.reviewWrite(paramVO);
        return "redirect:/contents/detail?idx="+contentsIdx;
    }

//    @PostMapping("/save")
//    @ResponseBody
//    public ResponseEntity<?> saveContent(@RequestBody ContentsVO contentsVO){
//        contentsVO.setRegistrationDate(LocalDateTime.now()
//                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        contentsService.contentSave(contentsVO);
//        System.out.println(contentsVO.getImages());
//        System.out.println(contentsVO.getPrice());
//        return new ResponseEntity<>("{}", HttpStatus.CREATED);
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveContent(@RequestParam("title") String title, @RequestParam("author") String author,
                                  @RequestParam("files") MultipartFile[] files, @RequestParam("price") String price,
                                  @RequestParam("runningTime") String runningTime, @RequestParam("createdDate") String createdDate,
                                  @RequestParam("description") String description
            , HttpServletResponse response){
        List<String> imagesList;

        imagesList = contentsService.saveImages(files);

        ContentsVO contentsVO= ContentsVO.builder()
                .title(title)
                .author(author)
                .images(imagesList)
                .price(price)
                .runningTime(runningTime)
                .createdDate(createdDate)
                .description(description)
                .build();
        
        contentsService.contentSave(contentsVO);
        response.setContentType("multipart/form-data");
        return "redirect:/main";
    }



    @RequestMapping("/cartList")
    public String cartList() {
        return "/contents/cartList";
    }

    @RequestMapping("/cartInsert")
    public String cartInsert(@ModelAttribute CartVO paramVO){
        contentsService.cartInsert(paramVO);
        return "redirect:/contents/cartList";
    }

    @RequestMapping("/cartDelete")
    public String cartDelete(){
        return "redirect:/contents/cartList";
    }
}
