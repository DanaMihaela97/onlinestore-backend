package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.OrderConvertor;
import com.sda.onlinestore.convertor.UserConvertor;
import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.repository.OrderRepository;
import com.sda.onlinestore.service.OrderService;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

//    @Override
//    public OrderInfoDto createOrder(OrderCreateDto orderCreateDto) {
//        UserDto userDto = userService.getUserById(orderCreateDto.getUserId());
//        User user = UserConvertor.convertEntityToDto(userDto);
//        OrderList orderlist = orderRepository.save(OrderConvertor.toEntity(orderCreateDto, user));
//        OrderInfoDto orderInfoDto = OrderConvertor.entityToInfo(orderlist);
//        return orderInfoDto;
//
//    }

    @Override
    public OrderInfoDto createOrder(OrderCreateDto orderCreateDto) {
        return null;
    }

    @Override
    public List<OrderInfoDto> findAll() {
        return orderRepository.findAll().stream().map(OrderConvertor::entityToInfo).toList();
    }
}
