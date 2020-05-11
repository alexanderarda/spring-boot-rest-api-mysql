package com.alexanderarda.rest.service;

import com.alexanderarda.rest.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    Customer update(Customer customer);

    Customer create(Customer customer);

    void delete(Long id);

}
