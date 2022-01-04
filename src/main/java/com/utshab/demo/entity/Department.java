package com.utshab.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // creates Getters and Setters
@NoArgsConstructor // creates NoArgsConstructor
@AllArgsConstructor // creates AllArgsConstructor
@Builder // not clear concept

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Department name cannot be empty !")
    private String  departmentName;
    private String departmentAddress;
    private String departmentCode;
}
