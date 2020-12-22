package com.codegym.service;

import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Integer id);
    void delete(Employee employee);
    Page<Employee> findName(String name1,Pageable pageable);
    Employee findSelect( String select,String value);
    Page<Employee> findBirthday(String startday,String endday,Pageable pageable);
}
