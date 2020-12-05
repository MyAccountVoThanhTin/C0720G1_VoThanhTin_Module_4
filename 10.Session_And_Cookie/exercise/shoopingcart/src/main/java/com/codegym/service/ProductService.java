package com.codegym.service;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer integer);
    void save(Product product);
    void delete(Product product);
    Page<Product> findAll(Pageable pageable);
}
