package com.codegym.repository;

import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    @Query(value = "select * from employee " +
//            "inner join position  on employee.id_division = position.id " +
//            "where employee.employee_name like ?1 or employee.emoloyee_address like ?2 or position.position_name like ?3" ,nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContainingOrEmoloyeeAddressContainingOrPosition_positionNameContaining(String name1,  String name2, String name3 , Pageable pageable);
    @Query(value = "select * from employee where ?1 like ?2",nativeQuery = true)
    Employee findSelect(String select,String value );
    Page<Employee> findAllByEmployeeBirthdayBetween(String starday,String endday,Pageable pageable);
}
