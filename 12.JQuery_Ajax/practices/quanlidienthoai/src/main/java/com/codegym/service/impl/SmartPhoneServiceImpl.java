package com.codegym.service.impl;

import com.codegym.entity.SmartPhone;
import com.codegym.repository.SmartPhoneRepository;
import com.codegym.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SmartPhone phone) {
         smartPhoneRepository.save(phone);
    }

    @Override
    public void remove(SmartPhone phone) {
         smartPhoneRepository.delete(phone);
    }
}
