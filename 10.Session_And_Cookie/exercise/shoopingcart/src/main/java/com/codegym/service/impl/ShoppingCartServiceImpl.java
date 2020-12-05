package com.codegym.service.impl;

import com.codegym.entity.ShoppingCart;
import com.codegym.entity.User;
import com.codegym.repository.ShoppingCartRepository;
import com.codegym.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart findById(Integer id) {
        return shoppingCartRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        shoppingCartRepository.delete(shoppingCart);
    }

    @Override
    public Page<ShoppingCart> findAll(Pageable pageable) {
        return shoppingCartRepository.findAll(pageable);
    }
}
