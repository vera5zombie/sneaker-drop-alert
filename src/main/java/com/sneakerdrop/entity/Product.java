package com.sneakerdrop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productId;
    private String siteId;
    private String productName;
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}

