package com.codegym.repository;

import com.codegym.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
