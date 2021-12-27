package com.utshab.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(
                1,
                "Roy",
                "roy@email.com",
                LocalDate.of(2000, Month.NOVEMBER, 30),
                21
        ));
    }
}
