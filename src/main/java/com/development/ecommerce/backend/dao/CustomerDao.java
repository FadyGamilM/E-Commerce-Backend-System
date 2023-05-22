package com.development.ecommerce.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.development.ecommerce.backend.domain.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>{
    @Query(value = "SELECT * FROM customers WHERE id=?1", nativeQuery = true)
    public Customer getCustomerById (Long id);

    @Query(value = "SELECT * FROM customers", nativeQuery = true)
    public List<Customer> getAllCustomers ();
}