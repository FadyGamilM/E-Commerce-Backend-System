package com.development.ecommerce.backend.api.models.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterationDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}