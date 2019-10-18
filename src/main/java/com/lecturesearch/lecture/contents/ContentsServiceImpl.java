package com.lecturesearch.lecture.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentsServiceImpl implements ContentsService {

    @Autowired
    ContentsRepository contentsRepository;

    @Override
    public Iterable<ContentsVO> findAll() {
        return contentsRepository.findAll();
    }
}
