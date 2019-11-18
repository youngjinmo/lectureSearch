package com.lecturesearch.lecture.OAuth2.repository;

import com.lecturesearch.lecture.OAuth2.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByEmail(String email);
}
