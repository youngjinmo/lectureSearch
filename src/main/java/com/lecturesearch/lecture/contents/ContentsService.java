package com.lecturesearch.lecture.contents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContentsService {

//    //콘텐츠 리스트 보기
//    Iterable<ContentsVO> contentsList();

    //콘텐츠 등록
    ContentsVO insert(ContentsVO paramVO);

    //Paging list
    Page<ContentsVO> findContentsList(Pageable pageable);

    //콘텐츠 상세보기
    ContentsVO detailView(String idx);

    //서치후페이징 리스트보기
   Page<ContentsVO> searchTitle(String title,Pageable pageable);

   //리뷰작성
   ReviewVO reviewWrite(ReviewVO paramVO);

   ContentsVO contentSave(ContentsVO contentsVO);

   List<String> saveImages(MultipartFile[] files);

   //리뷰리스트
    Page<ReviewVO> findReviewList(String contentsIdx, Pageable pageable);

    //장바구니 담기
    CartVO cartInsert(CartVO paramVO);

    //장바구니 삭제
}
