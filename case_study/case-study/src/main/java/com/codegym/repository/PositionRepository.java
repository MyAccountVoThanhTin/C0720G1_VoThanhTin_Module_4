package com.codegym.repository;

import com.codegym.entity.Division;
import com.codegym.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
