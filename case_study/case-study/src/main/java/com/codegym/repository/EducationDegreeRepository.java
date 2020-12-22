package com.codegym.repository;

import com.codegym.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface EducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
