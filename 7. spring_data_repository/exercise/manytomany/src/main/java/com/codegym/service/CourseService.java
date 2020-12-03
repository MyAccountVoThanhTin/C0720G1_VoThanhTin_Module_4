package com.codegym.service;

import com.codegym.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Integer id);
    void save(Course course);
    void delete(Course course);
    Page<Course> findAll(Pageable pageable);
}
