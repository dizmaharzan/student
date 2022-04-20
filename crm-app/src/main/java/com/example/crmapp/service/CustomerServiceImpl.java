package com.example.crmapp.service;


import com.example.crmapp.model.Customer;
import com.example.crmapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(int id) {
        Customer customer=customerRepository.findById(id).get();
        customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return   customerRepository.findById(id).get();
    }
}