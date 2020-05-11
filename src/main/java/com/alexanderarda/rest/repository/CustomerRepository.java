package com.alexanderarda.rest.repository;

import com.alexanderarda.rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
