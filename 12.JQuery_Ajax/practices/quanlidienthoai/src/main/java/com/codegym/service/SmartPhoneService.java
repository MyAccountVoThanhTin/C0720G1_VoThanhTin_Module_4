package com.codegym.service;

import com.codegym.entity.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    void save(SmartPhone phone);
    void remove(SmartPhone phone);
}
