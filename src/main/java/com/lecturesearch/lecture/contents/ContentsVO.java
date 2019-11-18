package com.lecturesearch.lecture.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "lecture", type = "contents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentsVO {

    @Id
    private String idx;
    private String title;
    private String author;
    private String subject;
    private List<String> images = new ArrayList<>();
    private String price;
    private String description;
    private String createdDate;
    private String runningTime;
    private String registrationDate;
    private String writer;


//    public ContentsVO(String no, String title, String subject, String price, String uploadDate, String runningTime) {
//        this.no = no;
//        this.title = title;
//        this.subject = subject;
//        this.price = price;
//        this.uploadDate = uploadDate;
//        this.runningTime = runningTime;
//    }

    @Builder
    public ContentsVO(String title, String author, String subject, List<String> images,
                      String price, String description, String createdDate, String runningTime,
                      String registrationDate, String writer) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.images = images;
        this.price = price;
        this.description = description;
        this.createdDate = createdDate;
        this.runningTime = runningTime;
        this.registrationDate = registrationDate;
        this.writer = writer;
    }
}
