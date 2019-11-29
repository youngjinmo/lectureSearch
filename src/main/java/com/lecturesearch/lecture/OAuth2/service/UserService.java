package com.lecturesearch.lecture.OAuth2.service;

import com.lecturesearch.lecture.OAuth2.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAll();

    User findByEmail(String email);
}
