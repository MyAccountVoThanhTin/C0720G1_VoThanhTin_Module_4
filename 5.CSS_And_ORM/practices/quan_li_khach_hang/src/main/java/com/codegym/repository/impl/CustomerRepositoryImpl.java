package com.codegym.repository.impl;

import com.codegym.entity.Customer;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> typedQuery = BaseRepository.entityManager.createQuery("select s from customer s", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(findById(customer.getId()) == null){
            BaseRepository.entityManager.persist(customer);
        }else {
            BaseRepository.entityManager.merge(customer);
        }
        entityTransaction.commit();
    }

    @Override
    public void remove(Customer customer) {
        BaseRepository.entityManager.remove(findById(customer.getId()));
    }
}
