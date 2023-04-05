package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.OrderConvertor;
import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Status;

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
    @Override
    public OrderInfoDto findById(Integer id) {
        OrderList orderList = orderRepository.findById(id).get();
        return OrderConvertor.entityToInfo(orderList);
    }
    @Override
    public OrderInfoDto save(OrderList order) {
        return OrderConvertor.entityToInfo(orderRepository.save(order));
    }
    @Override
    public OrderInfoDto createOrder(OrderCreateDto orderCreateDto) {
        OrderList orderList = orderRepository.save(
                        OrderConvertor.toEntity(orderCreateDto,
                        userService.findByEmail(orderCreateDto.getUser_email()))
                        );
        OrderInfoDto orderInfoDto = OrderConvertor.entityToInfo(orderList);
        return orderInfoDto;
    }

    @Override
    public List<OrderInfoDto> findAll() {
        return orderRepository.findAll().stream().map(OrderConvertor::entityToInfo).toList();
    }

    @Override
    public OrderInfoDto updateOrder(String id, String order_id, OrderInfoDto orderInfoDto){
    OrderList orderList = orderRepository.findById(Integer.valueOf(order_id)).get();

    orderList.setStatus(Status.valueOf(orderInfoDto.getOrder_status()));
    orderList.setCity(orderInfoDto.getCity());
    orderList.setPhoneNumber(orderInfoDto.getPhoneNumber());
    orderList.setDeliveryAddress(orderInfoDto.getDeliveryAddress());
    orderList.setTotalCost(orderInfoDto.getTotalCost());
    return OrderConvertor.entityToInfo(orderRepository.save(orderList));
    }

    @Override
    public List<OrderList> getOrdersByUserEmail(String user_email) {
        List<OrderList> orderLists = orderRepository.getAllOrdersByUserEmail(user_email);

        return orderLists;

    }
}
