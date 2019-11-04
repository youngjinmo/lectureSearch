package com.lecturesearch.lecture.OAuth2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
//@Document(indexName = "lecture", type = "user")

public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    private LocalDateTime createdDate;

    @Column
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
