package com.codegym.service.impl;

import com.codegym.entity.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServieImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findName(String name1, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContainingOrEmoloyeeAddressContainingOrPosition_positionNameContaining(name1,name1,name1,pageable);
    }

    @Override
    public Employee findSelect( String select, String value) {
        Employee employee = employeeRepository.findSelect(select,"%"+value+"%");
//        System.out.println(employee.getEmployeeName());
        return employee;
    }

    @Override
    public Page<Employee> findBirthday(String startday, String endday,Pageable pageable) {
        return employeeRepository.findAllByEmployeeBirthdayBetween(startday,endday,pageable);
    }

}
