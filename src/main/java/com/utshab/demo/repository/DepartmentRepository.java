package com.utshab.demo.repository;

import java.util.List;

import com.utshab.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public List<Department> findByDepartmentNameIgnoreCase(String departmentName);

}
