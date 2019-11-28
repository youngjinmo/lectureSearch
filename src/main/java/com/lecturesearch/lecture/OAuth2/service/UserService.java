package com.lecturesearch.lecture.OAuth2.service;

import com.lecturesearch.lecture.OAuth2.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void saveUser(User user);
}
