package com.codegym.service;

import com.codegym.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void delete(Student student);
    Page<Student> findAll(Pageable pageable);
}
