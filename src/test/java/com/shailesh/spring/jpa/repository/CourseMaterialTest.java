package com.shailesh.spring.jpa.repository;

import com.shailesh.spring.jpa.entity.Course;
import com.shailesh.spring.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseMaterialTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial()
    {
        Course course1 = Course.builder()
                .title("DSA")
                .credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course1).build();

        courseMaterialRepository.save(courseMaterial);
    }

}
