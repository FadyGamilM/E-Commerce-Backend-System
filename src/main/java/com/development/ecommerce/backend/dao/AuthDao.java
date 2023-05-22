package com.development.ecommerce.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.development.ecommerce.backend.domain.Customer;

@Repository
public interface AuthDao extends JpaRepository<Customer, Long>{
    @Query(value = "SELECT * FROM customers WHERE UPPER(email) LIKE UPPER(?1)", nativeQuery = true)
    public Customer findCustomerByEmail(String email);

    @Query(value = "SELECT * FROM customers WHERE UPPER(username) LIKE UPPER(?1)", nativeQuery = true)
    public Customer findCustomerByUsername(String username);
}