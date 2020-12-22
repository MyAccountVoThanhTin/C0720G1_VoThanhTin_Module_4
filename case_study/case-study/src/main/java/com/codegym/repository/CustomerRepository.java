package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
