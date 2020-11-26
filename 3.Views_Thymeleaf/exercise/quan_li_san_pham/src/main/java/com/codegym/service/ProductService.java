package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    void createNew(Product product);
    void delete(int id);
    void update(int id ,Product product);
}
