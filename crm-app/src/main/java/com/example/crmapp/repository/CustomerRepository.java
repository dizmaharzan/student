package com.example.crmapp.repository;

import com.example.crmapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
