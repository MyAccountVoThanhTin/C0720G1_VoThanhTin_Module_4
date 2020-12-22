package com.codegym.service;

import com.codegym.entity.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(Integer idEducation);
}
