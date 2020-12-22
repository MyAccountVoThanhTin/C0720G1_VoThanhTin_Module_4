package com.codegym.repository;

import com.codegym.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
