package com.development.ecommerce.backend.api.controllers.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.ecommerce.backend.api.models.RegisterationDto;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @PostMapping("/register")
    public void Register(@RequestBody RegisterationDto dto){
        
    }
}