package com.sda.onlinestore.entity;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class User {
    @Id

    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String city;
    @Column
    private String avatar;
    @Column
    private String phoneNumber;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_role")
    private Role role;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    List<OrderList> orders;

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<OrderList> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderList> orders) {
        this.orders = orders;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public User(Integer id, String name, String email, String city, String avatar, String phoneNumber, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
