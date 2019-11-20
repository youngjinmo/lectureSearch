package com.lecturesearch.lecture.contents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends ElasticsearchRepository<CartVO, String> {
    //장바구니 리스트
    Page<CartVO> findAllByEmail(String email, Pageable pageable);

    //장바구니 담기
    CartVO save(CartVO paramVO);

    //장바구니 삭제

}
