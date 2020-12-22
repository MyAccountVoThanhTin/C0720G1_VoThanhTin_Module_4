package com.codegym.repository;

import com.codegym.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
