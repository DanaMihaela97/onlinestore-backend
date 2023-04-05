package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Status;
import com.sda.onlinestore.entity.User;

import java.util.List;


public interface OrderService  {
    OrderInfoDto findById(Integer id);
    OrderInfoDto save(OrderList order);

    OrderInfoDto createOrder(OrderCreateDto orderCreateDto);
    List<OrderInfoDto> findAll();

    OrderInfoDto updateOrder(String email, String order_id, OrderInfoDto orderInfoDto);
    List<OrderList> getOrdersByUserEmail(String user_email);
}
