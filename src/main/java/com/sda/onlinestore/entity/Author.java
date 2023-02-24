package com.sda.onlinestore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="author")
public class Author {
    @Id
    @Column
    private String name;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="author")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

