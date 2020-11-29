package com.codegym.repository;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Customer customer);
}
