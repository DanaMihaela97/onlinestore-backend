package com.sda.onlinestore.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Category {
    @Id
    private String name;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="category")
    List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
