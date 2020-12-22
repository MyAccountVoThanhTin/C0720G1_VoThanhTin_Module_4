package com.codegym.repository;

import com.codegym.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
