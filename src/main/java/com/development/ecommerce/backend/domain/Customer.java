package com.development.ecommerce.backend.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 70)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "encrypted_password", nullable = false)
    private String password;

    // specify that the `customer` attribute in the `Addresses` with the `Address`
    // domain class relation is mapped to this `customers` relation with this
    // `Customer` domain class
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    // ➜ domain methods
    // to set the address to the owner
    public void addAddress(Address address) {
        if (address != null)
            this.addresses.add(address);

        // then mapp this customer with this address
        address.setAddressOwner(this);
    }

    // to remove the address from the owner
    public void removeAddress(Address address) {
        if (address != null) {
            this.addresses.remove(address);
        }
        // then update the info in the address side
        address.setAddressOwner(null);
    }

}