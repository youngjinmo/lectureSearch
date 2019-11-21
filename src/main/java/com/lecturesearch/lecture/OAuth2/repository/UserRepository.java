package com.lecturesearch.lecture.OAuth2.repository;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.password.PasswordEncoding;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByEmail(String email);
}


