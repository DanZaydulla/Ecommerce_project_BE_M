package com.example.Ecommerce_project_BE.controller;

import com.example.Ecommerce_project_BE.model.Customer;
import com.example.Ecommerce_project_BE.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")


public class CustomerController {

    @Autowired
    private CustomerService customerService;




    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        try {
            customerService.createCustomer(customer);
            return ResponseEntity.ok().body("Customer created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating customer: " + e.getMessage());
        }
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer customerId) {
        try {
            Customer customer = customerService.findCustomerById(customerId);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}







