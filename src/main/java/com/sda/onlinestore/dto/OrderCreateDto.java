package com.sda.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sda.onlinestore.entity.User;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;


public class OrderCreateDto {
    private String phoneNumber;
    private Double totalCost;
    private String city;

    private String deliveryAddress;
//    @Transient // calc pt tine
//    @JsonFormat(pattern="yyyy-MM-DD HH:mm:ss")
    private LocalDateTime dateOfSubmission;
    private String user_email;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }



    // de facut update pe status
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public LocalDateTime getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(LocalDateTime dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }


}
