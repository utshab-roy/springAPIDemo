package com.utshab.demo.repository;

import com.utshab.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void createSimpleCourse(){
        Course course = Course.builder()
                .title("English")
                .credit(4)
                .build();
        courseRepository.save(course);
    }
}
