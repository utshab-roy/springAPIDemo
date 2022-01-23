package com.utshab.demo.repository;

import com.utshab.demo.entity.Guardian;
import com.utshab.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("roy@gmail.com")
                .name("roy")
                .mobile("1234111")
                .build();

        Student student = Student.builder()
                .firstName("utshab")
                .lastName("roy")
                .emailId("utshab@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void findStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Ashik");
        System.out.println(students);
    }

    @Test
    public void findByLastNameNotNull(){
        Object students =
                studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void asFindStudentByGuardianName(){
        Object students =
                studentRepository.findByGuardianName("Atiquer");
        System.out.println(students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.findByEmailAddress("utshab@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetFirstNameByEmailAddress(){
        String studentName = studentRepository.getFirstNameByEmailAddress("utshab@gmail.com");
        System.out.println(studentName);
    }

    @Test
    public void printGetFirstNameByEmailAddressNative(){
        Student student = studentRepository.getFirstNameByEmailAddressNative("utshab@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgGetFirstNameByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getFirstNameByEmailAddressNativeNamedParam("utshab@gmail.com");
        System.out.println(student);
    }

}
