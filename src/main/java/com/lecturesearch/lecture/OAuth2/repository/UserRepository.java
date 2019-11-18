package com.lecturesearch.lecture.OAuth2.repository;

import com.lecturesearch.lecture.OAuth2.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByEmail(String email);

    PasswordEncoder passwordEncoder = new PasswordEncoder() {
        @Override
        public String encode(CharSequence rawPassword) {
            return null;
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return false;
        }
    };
//    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
}


