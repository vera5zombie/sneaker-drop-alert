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
public class Product {
    @Id
    private String productId;
    private String productName;
    private Boolean inStock;

    @ManyToOne
    @JoinColumn(name = "user_id") // Ensure this matches the column name in the database
    private User user;
}

