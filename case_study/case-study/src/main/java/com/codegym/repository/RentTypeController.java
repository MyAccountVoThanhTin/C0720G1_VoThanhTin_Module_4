package com.codegym.repository;

import com.codegym.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface RentTypeController extends JpaRepository<RentType,Integer> {
}
