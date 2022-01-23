package com.utshab.demo.repository;

import com.utshab.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);

    // this will work as like in sql
    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull(); // this method does not take parameter

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.emailId = ?1")
    Student findByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getFirstNameByEmailAddress(String emailId);

    //native query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getFirstNameByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getFirstNameByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // for updating data using query
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
