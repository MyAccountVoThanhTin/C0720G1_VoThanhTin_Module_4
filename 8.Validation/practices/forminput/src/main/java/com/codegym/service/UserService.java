package com.codegym.service;

import com.codegym.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserService {

    List<User> findAll();
    void save(User user);
}
