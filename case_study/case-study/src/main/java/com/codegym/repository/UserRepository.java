package com.codegym.repository;

import com.codegym.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
