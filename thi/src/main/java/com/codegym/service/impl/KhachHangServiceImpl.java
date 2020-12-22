package com.codegym.service.impl;

import com.codegym.entity.KhachHang;
import com.codegym.repository.KhachHangRepository;
import com.codegym.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang findById(Integer id) {
        return khachHangRepository.findById(id).orElse(null);
    }
}
