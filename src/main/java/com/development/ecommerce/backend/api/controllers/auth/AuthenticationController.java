package com.development.ecommerce.backend.api.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.ecommerce.backend.api.exceptions.CustomerAlreadyExistsException;
import com.development.ecommerce.backend.api.models.auth.RegisterationDto;
import com.development.ecommerce.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthService _service;

    AuthenticationController(AuthService service){
        _service = service;
    }

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody RegisterationDto dto){
        try{
            return ResponseEntity.ok().body(_service.RegisterCustomer(dto));
            // return _service.RegisterCustomer(dto);
        }catch(CustomerAlreadyExistsException ex){
            return ResponseEntity.badRequest().body("username or email is already in use !");
        }
    }
}