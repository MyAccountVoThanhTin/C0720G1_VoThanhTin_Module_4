package com.example.service;

import com.example.entity.Student;

public interface StudentService {
    Student findById(Integer id) throws Exception;
}
