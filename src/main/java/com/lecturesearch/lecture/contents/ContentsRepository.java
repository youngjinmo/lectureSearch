package com.lecturesearch.lecture.contents;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsRepository extends ElasticsearchRepository<ContentsVO, String> {

    Iterable<ContentsVO> findAll();
}
