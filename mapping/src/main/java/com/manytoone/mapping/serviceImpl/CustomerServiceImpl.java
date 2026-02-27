package com.manytoone.mapping.serviceImpl;

import com.manytoone.mapping.repository.CustomerRepository;
import com.manytoone.mapping.repository.ProductRepository;
import com.manytoone.mapping.service.CustomerService;
import com.manytoone.mapping.vo.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer updateData(Customer customer, Long id) {
		Optional<Customer> data = customerRepository.findById(id);
		if (data.isPresent()) {
			Customer custr = data.get();
			custr.setCustName(customer.getCustName());
			custr.setEmail(customer.getEmail());
			custr.setGender(customer.getGender());
			custr.setId(customer.getId());
			custr.setProduct(customer.getProduct());
			return customerRepository.save(custr);
		}
		return null;
	}
}
