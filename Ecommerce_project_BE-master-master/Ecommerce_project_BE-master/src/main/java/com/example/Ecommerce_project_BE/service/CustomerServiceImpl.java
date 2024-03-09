package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Customer;
import com.example.Ecommerce_project_BE.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer){
        customerRepository.createCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Integer customerId){
        return customerRepository.findCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

}

