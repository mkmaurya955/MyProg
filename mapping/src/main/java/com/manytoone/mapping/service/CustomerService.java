package com.manytoone.mapping.service;

import java.util.List;

import com.manytoone.mapping.vo.Customer;

public interface CustomerService {
    Customer create(Customer customer);

	List<Customer> getAllData();

	Customer updateData(Customer customer, Long id);
}
