package com.development.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.ecommerce.backend.dao.CustomerDao;
import com.development.ecommerce.backend.domain.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao _dao;
    CustomerService(CustomerDao dao){
        _dao = dao;
    }

    public Customer GetCustomerById(Long customerId){
        return _dao.getCustomerById(customerId);
    }

    public List<Customer> GetAllCustomers(){
        return _dao.getAllCustomers();
    }
}