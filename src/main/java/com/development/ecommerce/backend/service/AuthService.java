package com.development.ecommerce.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.development.ecommerce.backend.api.exceptions.CustomerAlreadyExistsException;
import com.development.ecommerce.backend.api.models.auth.RegisterationDto;
import com.development.ecommerce.backend.dao.AuthDao;
import com.development.ecommerce.backend.domain.Customer;

@Service
public class AuthService {
    @Autowired
    private AuthDao _dao;

    AuthService(AuthDao dao){
        _dao = dao;
    }

    /**
     * 
     * @param customerDto
     * @return Customer domain entity
     * @Functionality persist new customer in the database
     */
    public Long RegisterCustomer(RegisterationDto customerDto) throws CustomerAlreadyExistsException {
        // first we need to check that there is no customer with this username or with this email in our database
        if (_dao.findCustomerByUsername(customerDto.getUsername()) != null || _dao.findCustomerByEmail(customerDto.getEmail()) != null ) throw new CustomerAlreadyExistsException("this email or username is already in use !");
        
        var newCustomer = new Customer();
        newCustomer.setFirstName(customerDto.getFirstName());
        newCustomer.setLastName(customerDto.getLastName());
        newCustomer.setUsername(customerDto.getUsername());
        newCustomer.setEmail(customerDto.getEmail());
        // TODO => we need to encrypt the password before saving it to the database 
        newCustomer.setPassword(customerDto.getPassword());
        return _dao.save(newCustomer).getId();
    }

}

