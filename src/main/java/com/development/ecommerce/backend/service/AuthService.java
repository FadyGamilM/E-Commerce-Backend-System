package com.development.ecommerce.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.ecommerce.backend.api.models.RegisterationDto;
import com.development.ecommerce.backend.dao.AuthDao;
import com.development.ecommerce.backend.domain.Customer;

@Service
public class AuthService {
    @Autowired
    private AuthDao _dao;

    AuthService(AuthDao dao){
        _dao = dao;
    }

    public Customer RegisterCustomer(RegisterationDto customerDto) {
        var newCustomer = new Customer();
        newCustomer.setFirstName(customerDto.getFirstName());
        newCustomer.setLastName(customerDto.getLastName());
        newCustomer.setUsername(customerDto.getUsername());
        newCustomer.setEmail(customerDto.getEmail());
        // TODO => we need to encrypt the password before saving it to the database 
        newCustomer.setPassword(customerDto.getPassword());
        return _dao.save(newCustomer);
    }
}

