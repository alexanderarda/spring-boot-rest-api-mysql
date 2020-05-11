package com.alexanderarda.rest.controller;

import com.alexanderarda.rest.Util.Response;
import com.alexanderarda.rest.entity.Customer;
import com.alexanderarda.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "customer")


public class CustomerController {


    @Autowired
    CustomerService customerService;

    // Create customer
    @PostMapping
    ResponseEntity<Response> create (@RequestBody @Validated Customer customer)
    {

        Response response = new Response();
        response.setService("Create customer");
        response.setMessage("Customer data has been created");

        response.setData(customerService.create(customer));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);

    }

    // Update customer
    @PutMapping(path = "/{id}")
    ResponseEntity<Response> update (@PathVariable ("id") Long id, @RequestBody @Validated Customer customer) /*Mengambil Request data dari Body dan melakukan Proses Validasi, diseleksi berdasarkan id*/
    {

        Response response = new Response();
        response.setService("Update Customer");
        response.setMessage("Customer data has been updated");

        Customer currentCustomer = customerService.findById(id);

        currentCustomer.setName(customer.getName());
        currentCustomer.setPhone(customer.getPhone());

        response.setData(customerService.update(currentCustomer));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);

    }

    // Get customer by Id
    @GetMapping(path = "/{id}")
    ResponseEntity getById (@PathVariable("id") Long id)/*Mengambil Request data dari Berdasarkan id*/
    {

        System.out.println("Get function ID = "+id);

        Response response = new Response();
        response.setService("Get customer by Id");
        response.setMessage("Data customer has been fetched");

        response.setData(customerService.findById(id));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    // Get all customers
    @GetMapping
    ResponseEntity<Response> findAll ()
    {

        Response response = new Response();
        response.setService("Get all data customer");
        response.setMessage("All data customer(s) has been fetched");

        response.setData(customerService.findAll());

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);

    }


    // Delete Customer
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Response> deleteById (@PathVariable ("id")Long id)
    {

        System.out.println("Delete user. ID = "+id);

        Response response = new Response();
        response.setService("Delete customer data");
        response.setMessage("Customer data has been deleted");
        response.setData(customerService.findById(id));

        customerService.delete(id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);


    }

}
