package com.alexanderarda.rest;

import com.alexanderarda.rest.entity.Customer;
import com.alexanderarda.rest.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer(){

        Customer customer = new Customer();
        customer.setName("Alex");
        customer.setPhone("0812345678");

        customerRepository.save(customer);

    }

}
