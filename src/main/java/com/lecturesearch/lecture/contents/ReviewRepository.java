package com.lecturesearch.lecture.contents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends ElasticsearchRepository<ReviewVO, String> {
    //리뷰작성하기
    ReviewVO save(ReviewVO paramVO);

    //리뷰 리스트
    Page<ReviewVO> findAllByContentsIdx(String contentsIdx, Pageable pageable);
}
