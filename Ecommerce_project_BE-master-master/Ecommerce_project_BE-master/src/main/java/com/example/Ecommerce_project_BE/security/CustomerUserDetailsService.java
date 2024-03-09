package com.example.Ecommerce_project_BE.security;
import com.example.Ecommerce_project_BE.model.Customer;
import com.example.Ecommerce_project_BE.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;
//
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByUsername(username);

        if(customer == null){
            throw new UsernameNotFoundException("The provided username can't be found");
        }

        return User.withUsername(customer.getUsername()).password(customer.getPassword()).authorities("USER").build();
    }
}
