package com.lecturesearch.lecture.OAuth2.repository;

import com.lecturesearch.lecture.OAuth2.domain.User;
import com.lecturesearch.lecture.OAuth2.password.PasswordEncoding;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByEmail(String email);

    List<User> findAll();
}


