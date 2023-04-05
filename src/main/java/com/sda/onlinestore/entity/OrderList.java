package com.sda.onlinestore.entity;

import com.sda.onlinestore.dto.UserDto;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double totalCost;
    @Column
    private String deliveryAddress;
    @Column
    private String phoneNumber;
    @Column
    private String city;
    @Column
    private Date dateOfSubmission;

    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
//    @OneToMany(cascade=CascadeType.ALL)
//    private List<Product> products;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {

        this.dateOfSubmission = dateOfSubmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
