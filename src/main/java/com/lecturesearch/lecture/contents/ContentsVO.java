package com.lecturesearch.lecture.contents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void update(ContentsVO contentsVO){
        this.title = contentsVO.getTitle();
        this.author = contentsVO.getAuthor();
        this.subject = contentsVO.getSubject();
        this.images = contentsVO.getImages();
        this.price = contentsVO.getPrice();
        this.description = contentsVO.getDescription();
        this.createdDate = contentsVO.getCreatedDate();
        this.runningTime = contentsVO.getRunningTime();
    }
    public void setRegistrationDate(){
       this.registrationDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

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
