package com.development.ecommerce.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.development.ecommerce.backend.domain.Customer;

public interface AuthDao extends JpaRepository<Customer, Long>{
    
}