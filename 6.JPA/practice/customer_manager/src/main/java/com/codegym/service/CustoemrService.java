package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.Iterator;
import java.util.List;

public interface CustoemrService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void delete(Customer customer);
    void save(Customer customer);
}
