package com.utshab.demo.repository;

import com.utshab.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);

    // this will work as like in sql
    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull(); // this method does not take parameter

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastname(String firstName, String lastName);

}
