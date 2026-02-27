package com.manytoone.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manytoone.mapping.service.CustomerService;
import com.manytoone.mapping.vo.Customer;

@RestController
//@RequestMapping("/customer")
public class CustProdController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.create(customer);
    }
    
    @GetMapping("/getAllData")
    public List<Customer> AllData(){
    	return customerService.getAllData();
    }
    
    @PutMapping("/updataData/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
    	return customerService.updateData(customer, id);
    }
}
