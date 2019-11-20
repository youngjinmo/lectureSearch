package com.lecturesearch.lecture;

import com.lecturesearch.lecture.OAuth2.password.testPassword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureApplicationTests {

    @Test
    public void contextLoads() {
        testPassword testPassword =new testPassword();
        testPassword.test();
    }

}
