package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;

import java.util.List;

public interface ProvinceService{
    List<Province> findAll();
    Province findById(Integer id);
    void delete(Province province);
    void save(Province province);
}
