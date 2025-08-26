package com.example.Mapping.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue
    private int item_id;
    private String name;
//    public Item(String name)
//    {
//        this.name=name;
//    }

//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "item")
//    private Customer customer;


}
