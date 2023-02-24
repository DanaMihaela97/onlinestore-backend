package com.sda.onlinestore.convertor;


import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.User;

import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConvertor {


    public static OrderList toEntity(OrderCreateDto orderCreateDto, User user){
        OrderList orderList = new OrderList();
        orderList.setDeliveryAddress(orderCreateDto.getDeliveryAddress());
        orderList.setDateOfSubmission(orderCreateDto.getDateOfSubmission());
        orderList.setPhoneNumber(orderCreateDto.getPhoneNumber());
        orderList.setUser(user);

        return orderList;
    }

    public static OrderInfoDto entityToInfo(OrderList orderList){
        OrderInfoDto orderInfoDto=new OrderInfoDto();
        orderInfoDto.setDeliveryAddress(orderList.getDeliveryAddress());
        orderInfoDto.setDateOfSubmission(orderList.getDateOfSubmission());
        orderInfoDto.setTotalCost(orderList.getTotalCost());
        orderInfoDto.setUser_id(orderList.getUser().getId());

        return orderInfoDto;
    }
    public static OrderInfoDto entityToInfo(OrderCreateDto orderCreateDto){
        OrderInfoDto orderInfoDto=new OrderInfoDto();
        orderInfoDto.setDeliveryAddress(orderCreateDto.getDeliveryAddress());
        orderInfoDto.setDateOfSubmission(orderCreateDto.getDateOfSubmission());
        orderInfoDto.setTotalCost(orderCreateDto.getTotalCost());
        orderInfoDto.setUser_id(orderCreateDto.getUserId());

        return orderInfoDto;
    }
}
