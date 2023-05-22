package com.development.ecommerce.backend.api.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.ecommerce.backend.api.models.RegisterationDto;
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
    public Long Register(@RequestBody RegisterationDto dto){
        return _service.RegisterCustomer(dto).getId();
    }
}