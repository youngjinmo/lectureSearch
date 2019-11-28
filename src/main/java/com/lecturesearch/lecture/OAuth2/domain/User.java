package com.lecturesearch.lecture.OAuth2.domain;

import com.lecturesearch.lecture.OAuth2.SocialType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(indexName = "user", type = "info")
public class User {

    @Id
    private long idx;

    private String name;

    private String email;

    private String password;

    private String principal;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String createdDate;

    private String updatedDate;

    @Builder
    public User(String name, String password,
                String email, String createdDate, String updatedDate,
                String principal, SocialType socialType){
        this.name=name;
        this.password=password;
        this.email=email;
        this.principal=principal;
        this.socialType=socialType;
        this.createdDate=createdDate;
        this.updatedDate=updatedDate;
    }

    public void setCreatedDate(){//facebook, google 에서 제공하는 시간대와 맞춤
        this.createdDate=LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toString();
    }
    public void setUpdatedDate() {
        this.updatedDate=LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()).toString();
    }

}