package com.utshab.demo.service;

import com.utshab.demo.entity.Department;
import com.utshab.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach // this method will call every time a test runs
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Dhaka")
                .departmentCode("1010")
                .departmentId(1L)
                .build();

        // findByDepartmentNameIgnoreCase method gives us a list of department
        // so that we have to return a list while mocking in the repository
        List<Department> departmentList = new LinkedList<>();
        departmentList.add(department);

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn((departmentList));
    }

    @Test
    @DisplayName("Get data based on valid department name")
//    @Disabled // this annotation is used when we want to disable one particular test case
    public void whenValidDepartmentName_thenDepartmentShouldFound()
    {
        String departmentName = "IT";
        List<Department> foundList = departmentService.fetchDepartmentByName(departmentName);
        Department found = foundList.get(0); // taking the first department of the list

        assertEquals(departmentName, found.getDepartmentName()); // check if the value is equal
    }
}
