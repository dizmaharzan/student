package com.example.crmapp.service;


import com.example.crmapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomer();

    public Customer createCustomer(Customer customer);

    public void deleteCustomer(int id);

    public Customer getCustomer(int id);
}