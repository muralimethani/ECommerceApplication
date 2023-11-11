package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Integer totalCost;

    Integer numberOfItems;


    // Child for Customer
    @OneToOne
    @JoinColumn
    Customer customer;

    // Cart is Parent for Item
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL )
    List<Item> items = new ArrayList<>();


}
