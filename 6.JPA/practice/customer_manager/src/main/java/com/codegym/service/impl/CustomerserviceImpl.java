package com.codegym.service.impl;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustoemrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CustomerserviceImpl implements CustoemrService {
    @Qualifier("customerRepository")
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
