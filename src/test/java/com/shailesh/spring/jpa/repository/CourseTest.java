package com.shailesh.spring.jpa.repository;

import com.shailesh.spring.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void savaCourse()
    {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        courseRepository.save(course);
    }

}
