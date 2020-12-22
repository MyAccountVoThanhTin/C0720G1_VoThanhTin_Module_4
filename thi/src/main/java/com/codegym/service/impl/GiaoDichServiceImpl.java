package com.codegym.service.impl;

import com.codegym.entity.GiaoDich;
import com.codegym.repository.GiaoDichRepository;
import com.codegym.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Override
    public Page<GiaoDich> findAll(Pageable pageable) {
        return giaoDichRepository.findAll(pageable);
    }

    @Override
    public GiaoDich findById(Integer id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(GiaoDich giaoDich) {
        giaoDichRepository.delete(giaoDich);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public Page<GiaoDich> findByName(String timkiem, Pageable pageable) {
        return giaoDichRepository.findAllByKhachHang_TenKHContaining(timkiem,pageable);
    }
}
