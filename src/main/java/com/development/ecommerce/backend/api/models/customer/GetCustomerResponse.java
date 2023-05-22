package com.development.ecommerce.backend.api.models.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}