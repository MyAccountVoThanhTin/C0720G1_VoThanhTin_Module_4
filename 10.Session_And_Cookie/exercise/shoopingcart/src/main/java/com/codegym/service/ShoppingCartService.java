package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.entity.ShoppingCart;
import com.codegym.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> findAll();
    ShoppingCart findById(Integer integer);
    void save(ShoppingCart shoppingCart);
    void delete(ShoppingCart shoppingCart);
    Page<ShoppingCart> findAll(Pageable pageable);
}
