package com.codegym.service;

import com.codegym.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {
    Page<KhachHang> findAll(Pageable pageable);

    KhachHang findById(Integer id);
}
