package com.lecturesearch.lecture.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    public List<Board> searchTitle(String title){
        return searchRepository.findAllByTitle(title);
    }

    public Board saveBoard(Board board){
        return searchRepository.save(board);
    }
}
