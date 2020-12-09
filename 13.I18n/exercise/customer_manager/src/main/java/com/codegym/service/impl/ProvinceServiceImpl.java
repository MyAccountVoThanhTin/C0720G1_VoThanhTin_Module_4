package com.codegym.service.impl;

import com.codegym.entity.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Qualifier("provinceRepository")
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Province province) {
        provinceRepository.delete(province);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }
}
