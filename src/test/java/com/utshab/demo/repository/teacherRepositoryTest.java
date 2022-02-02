package com.utshab.demo.repository;

import com.utshab.demo.entity.Course;
import com.utshab.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class teacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        // creating the course
        Course course201 = Course.builder()
                .title("Cse201")
                .credit(3)
                .build();

        Course course331 = Course.builder()
                .title("Cse331")
                .credit(3)
                .build();

        // creating the teacher
        Teacher teacher = Teacher.builder()
                .firstName("Ashraf")
                .lastName("Sir")
                .courses(List.of(course201, course331))
                .build();
        // saving the teacher
        teacherRepository.save(teacher);
    }
}
