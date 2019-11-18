package com.lecturesearch.lecture;

import com.lecturesearch.lecture.OAuth2.password.AAA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureApplicationTests {

    @Test
    public void contextLoads() {
        AAA aaa =new AAA();
        aaa.test();



    }

}
