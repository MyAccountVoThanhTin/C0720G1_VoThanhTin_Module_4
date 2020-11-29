package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Blog blog);
}
