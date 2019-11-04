package com.lecturesearch.lecture.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SearchRepository extends ElasticsearchRepository<Board,Long> {

    Board save(Board board);

    List<Board> findAllByTitle(String title);
}
