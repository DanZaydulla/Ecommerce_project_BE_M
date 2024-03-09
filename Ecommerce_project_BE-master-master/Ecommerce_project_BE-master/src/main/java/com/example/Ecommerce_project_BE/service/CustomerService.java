package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Customer;
import com.example.Ecommerce_project_BE.model.LoginRequest;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    Customer findCustomerById(Integer customerId);
    List<Customer> getAllCustomers();
//    Customer login(LoginRequest loginRequest);
}
