package com.codegym.repository;

import com.codegym.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
