package com.lecturesearch.lecture.contents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "review", type = "contents")
@Data
public class ReviewVO {
    @Id
    private String idx;
    private String star;
    private String writer;
    private String message;
    private String contentsIdx;
    private String date;
    private String name;

//    public ReviewVO(String star, String message, String no) {
//        this.star = star;
//        this.message = message;
//        this.no = no;
//    }
}
