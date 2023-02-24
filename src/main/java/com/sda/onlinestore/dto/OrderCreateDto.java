package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class OrderCreateDto {
//    @NotBlank(message="This field is mandatory.")
//    private String userName;
//    @Email(message="Invalid email")
//    @NotBlank(message="This field cannot be empty.")
//    private String userEmail;
    private String phoneNumber;
    private Double totalCost;
    @NotBlank(message="This field is mandatory.")
    private String deliveryAddress;
    private Date dateOfSubmission;
    private Integer user_id;


    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }


    // de facut update pe status


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String email) {
//        this.userEmail = email;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

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
}
