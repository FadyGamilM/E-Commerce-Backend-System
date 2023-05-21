package com.development.ecommerce.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// instead of counting how many records of product named `bla bla bla` from the products table to know how much quantity of it, we can sperate this info to a new table with a 1-1 relation and this `inventory` relation contains the quantity field ! :D
@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", unique = true, nullable = false) // the product_id can't be repeated for mroe than
                                                                      // one inventory
    private Product product;

    // ➜ domain methods
}