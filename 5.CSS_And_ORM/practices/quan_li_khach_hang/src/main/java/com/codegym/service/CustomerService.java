package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Customer customer);
}
