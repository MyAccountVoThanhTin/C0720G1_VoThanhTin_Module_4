package com.codegym.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(45)")
    private String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employees;
    public Position() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int position_id) {
        this.id = position_id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String position_name) {
        this.positionName = position_name;
    }
}
