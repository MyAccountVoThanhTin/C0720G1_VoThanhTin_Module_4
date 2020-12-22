package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(45)")
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    public EducationDegree(String education_degree_name) {
        this.educationDegreeName = education_degree_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int education_degree) {
        this.id = education_degree;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String education_degree_name) {
        this.educationDegreeName = education_degree_name;
    }
}
