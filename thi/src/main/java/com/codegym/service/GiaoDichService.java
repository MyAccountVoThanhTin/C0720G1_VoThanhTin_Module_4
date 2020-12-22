package com.codegym.service;

import com.codegym.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GiaoDichService {
    Page<GiaoDich> findAll(Pageable pageable);

    GiaoDich findById(Integer id);

    void delete(GiaoDich giaoDich);

    void save(GiaoDich giaoDich);

    Page<GiaoDich> findByName(String timkiem, Pageable pageable);
}
