package com.lecturesearch.lecture.contents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cart", type="contents")
@Data
public class CartVO {
        @Id
        private String idx;
        private String email;
        private String contentsIdx;
}
