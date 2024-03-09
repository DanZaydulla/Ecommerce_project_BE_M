package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Customer;
import com.example.Ecommerce_project_BE.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.Ecommerce_project_BE.Utils.Constants.CUSTOMER_TABLE_NAME;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + "(username, first_name, last_name, email, phone, address_country, address_city, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getUsername(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getAddressCountry(), customer.getAddressCity(), customer.getPassword());
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE customer_id = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerMapper(),customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
        return jdbcTemplate.query(sql, new CustomerMapper());
    }
}
