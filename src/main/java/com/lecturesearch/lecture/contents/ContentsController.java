package com.lecturesearch.lecture.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String detailView(String no, Model model) {
        ContentsVO i = contentsService.detailView(no);
        model.addAttribute("contents", i);
        return "/contents/detailView";
    }

    @RequestMapping("/insert")
    public String write() {
        //데이터 저장날짜형식
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String now = format1.format(time);

        //임시 데이터저장용
        for(int i = 0; i < 30; i++){
            ContentsVO paramVO = new ContentsVO("양념가득 치킨"+i, "인프런","파이썬","img_4.jpg","ss",55000,"파이썬은 문법 구조가 쉽기 때문에 프로그래밍을 처음 접하는 초보자도 쉽게 이해할 수 있어요. 파이썬은 그 어떤 프로그래밍 언어보다 확장성이 월등히 높은 언어에요. 데이터분석가도, 웹개발자도, 머신러닝 연구자도, 대학원생도 파이썬을 사용하죠. 당신이 어떤 업무를 맡더라도 파이썬만 알아두면 척척 대응하기 쉬워집니다.\n" +
                    "\n" +
                    "당연히 비전공자도 다룰 수 있습니다. 프로그래밍 언어는 만국공통어에요. 만약 C, Java 등의 언어를 접해봤다면 더욱 쉽게 파이썬을 익힐 수 있겠죠.\n" +
                    "\n" +
                    "파이썬의 기본부터 심화까지 차근차근 따라해보세요. 인프런이 제시하는 프로그래밍 학습 로드맵을 따라가면 어느덧 파이썬 프로그래밍을 마스터한 자신과 만나게 될 겁니다. ","2019년 7월 16일","12시간 39분", now);
            contentsService.insert(paramVO);
        }
     return "redirect:/main";
    }

    @RequestMapping("/review")
    public String reviewWrite(@ModelAttribute ReviewVO paramVO, Model model) {
        contentsService.reviewWrite(paramVO);
        return "redirect:/main";
    }
}
