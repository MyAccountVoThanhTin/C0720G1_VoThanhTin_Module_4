package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.List;

public interface CustoemrService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> search(String keyword,Pageable pageable);
    Customer findById(Integer id);
    void delete(Customer customer);
    void save(Customer customer);
}
