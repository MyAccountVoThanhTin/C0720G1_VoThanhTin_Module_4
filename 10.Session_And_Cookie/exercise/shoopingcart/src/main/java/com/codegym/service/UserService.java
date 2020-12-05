package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer integer);
    void save(User user);
    void delete(User user);
    Page<User> findAll(Pageable pageable);
    List<User> findByName(String name);
}
