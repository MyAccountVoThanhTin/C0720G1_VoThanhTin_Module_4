package com.codegym.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(45)")
    private String divisionName;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public Division() {
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

    public Division(String division_name) {
        this.divisionName = division_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int division_id) {
        this.id = division_id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String division_name) {
        this.divisionName = division_name;
    }
}
