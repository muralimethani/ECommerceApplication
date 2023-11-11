package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="item")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int requiredQuntity;


    // Item is child for Cart
    @ManyToOne
    @JoinColumn
    Cart cart;

    // Item is child for Order
    @ManyToOne
    @JoinColumn
    Ordered order;
}
