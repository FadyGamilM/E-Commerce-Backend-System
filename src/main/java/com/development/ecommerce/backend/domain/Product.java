package com.development.ecommerce.backend.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "in_stock", nullable = false)
    private Boolean inStock;

    // if we view the product from general page
    @Column(name = "short_desc", nullable = false)
    private String shortDescription;

    // if we view the product from the product's page
    @Column(name = "long_desc", nullable = true)
    private String longDescrioption;

    // if we remove the product entirely fromt he system we must remove the
    // inventory of this product
    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "product", orphanRemoval = true)
    // Product have no need for @JoinColumn because the Product is the Parent entity
    // not the Dependent entity
    private Inventory inventory;

    // ➜ domain methods
    public void reduceProductCountInInventory() {
        this.inventory.setQuantity(this.inventory.getQuantity() - 1);
    }

    public void increaseProductCountInInventory() {
        this.inventory.setQuantity(this.inventory.getQuantity() + 1);
    }
}