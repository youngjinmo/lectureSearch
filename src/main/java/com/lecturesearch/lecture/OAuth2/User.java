package com.lecturesearch.lecture.OAuth2;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(indexName = "user", type = "info")
public class User {

    @Id
    private String idx;

    private String name;

    private String password;

    private String email;

    private String principal;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, LocalDateTime createdDate,
                String principal, SocialType socialType , LocalDateTime updatedDate){
        this.name=name;
        this.password=password;
        this.email=email;
        this.principal=principal;
        this.socialType=socialType;
        this.createdDate=createdDate;
        this.updatedDate=updatedDate;
    }

}
