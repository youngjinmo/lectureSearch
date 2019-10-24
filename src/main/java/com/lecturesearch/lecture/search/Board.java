package com.lecturesearch.lecture.search;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@Document(indexName = "boards", type = "contents")
public class Board {

    @Id
    private Long boardNum;

    private String title;

    private String content;

    private String boardType;

    private String createdDate;

    private String updatedDate;

//    User user;

    public Board(Long boardNum, String title, String content, String boardType, String createdDate, String updatedDa0te)
    {
        this.boardNum=boardNum;
        this.title=title;
        this.content=content;
        this.boardType=boardType;
        this.createdDate=createdDate;
        this.updatedDate=updatedDa0te;
    }
}
