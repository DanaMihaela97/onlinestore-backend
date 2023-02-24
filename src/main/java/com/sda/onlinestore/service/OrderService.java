package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;

import java.util.List;


public interface OrderService  {

    OrderInfoDto createOrder(OrderCreateDto orderCreateDto);
    List<OrderInfoDto> findAll();
}
