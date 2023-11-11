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
@Table(name="customer")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String emailId;

    Integer age;

    String mobNo;

    String address;

    //Parent for Card
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Card> cards = new ArrayList<>();


    //Parent for Cart
    @OneToOne(mappedBy ="customer", cascade = CascadeType.ALL)
    Cart cart;

    // Parent for Order class
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Ordered>orderList = new ArrayList<>();



}
