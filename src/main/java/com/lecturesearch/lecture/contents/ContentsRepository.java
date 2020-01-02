package com.lecturesearch.lecture.contents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContentsRepository extends ElasticsearchRepository<ContentsVO, String> {

    //컨텐츠 리스트보기
//    Iterable<ContentsVO> findAll();

    //컨텐츠 인서트
    ContentsVO save(ContentsVO paramVO);

    //컨텐츠 상세보기
    Optional<ContentsVO> findById(String idx);

    //서치후 페이징 리스트보기
    Page<ContentsVO> findAllByTitle(String title, Pageable pageable);

    List<ContentsVO> findAll();
}
