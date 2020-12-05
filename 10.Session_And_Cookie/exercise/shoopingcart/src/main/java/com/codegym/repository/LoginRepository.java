package com.codegym.repository;

import com.codegym.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {
    Login findByUserName(String name);
}
