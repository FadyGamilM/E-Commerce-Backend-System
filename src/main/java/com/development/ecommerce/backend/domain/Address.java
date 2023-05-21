package com.development.ecommerce.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_line_address", nullable = false)
    private String lineAddress1;

    @Column(name = "second_line_address")
    private String lineAddress2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    // ➜ relations with customers table
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    // ➜ domain methods
    protected void setAddressOwner(Customer customer) {
        // first we need to check if this address already has an owner, if it has an
        // owner, we need to remove this address from the list of adddress of the old
        // owner
        if (this.customer != null)
            this.customer.getAddresses().remove(this);

        // then override this address's owner to be the new received owner
        this.customer = customer;
    }
}