package com.codegym.repository;

import com.codegym.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiaoDichRepository extends JpaRepository<GiaoDich,Integer> {
    Page<GiaoDich> findAllByKhachHang_TenKHContaining(String name, Pageable pageable);
}
