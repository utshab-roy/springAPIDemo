package com.utshab.demo.repository;

import com.utshab.demo.entity.Course;
import com.utshab.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Katrina")
                .lastName("Kaif")
                .build();

        Course course = Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        // example of paging the data
        // first parameter is page, it will divide the whole data divide by the size
        // and size is the number of row we want to retrieve
        Pageable pageWithTwoRecords = PageRequest.of(0, 2); // get course id 1, 2
        Pageable pageWithThreeRecords = PageRequest.of(1, 3); // get course id 4, 5, 6

        List<Course> courses = courseRepository.findAll(pageWithTwoRecords).getContent();
        List<Course> secondPageCourses = courseRepository.findAll(pageWithThreeRecords).getContent();

        System.out.println("First page:" + courses);
        System.out.println("Second page:" + secondPageCourses);

        long totalPages = courseRepository.findAll(pageWithTwoRecords).getTotalPages();
        System.out.println("Total number of pages: " + totalPages);

        long allElements = courseRepository.findAll(pageWithTwoRecords).getTotalElements();
        System.out.println("Total number of elements: " + allElements);
    }
}
