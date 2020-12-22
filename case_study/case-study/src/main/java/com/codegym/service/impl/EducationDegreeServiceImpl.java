package com.codegym.service.impl;

import com.codegym.entity.EducationDegree;
import com.codegym.repository.EducationDegreeRepository;
import com.codegym.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Integer idEducation) {
        return educationDegreeRepository.findById(idEducation).orElse(null);
    }
}
