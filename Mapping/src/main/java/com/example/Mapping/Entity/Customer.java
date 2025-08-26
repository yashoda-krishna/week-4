package com.example.Mapping.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;

//    public Customer(String name)
//    {
//        this.name=name;
//}


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @OneToMany(cascade = CascadeType.ALL)

    private List<Item> items=new ArrayList<>();

}