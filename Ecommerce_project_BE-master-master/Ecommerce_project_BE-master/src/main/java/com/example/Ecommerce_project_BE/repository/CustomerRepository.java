package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    Customer findCustomerById(Integer customerId);
    List<Customer> getAllCustomers();
}
