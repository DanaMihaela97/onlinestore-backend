package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.dto.UserInfoDto;
import com.sda.onlinestore.entity.User;
import com.sda.onlinestore.service.OrderService;
import com.sda.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/users/{user_id}/orders/")
    public ResponseEntity<OrderInfoDto> createOrder(@PathVariable String user_id, @RequestBody OrderCreateDto orderCreateDto){
        orderCreateDto.setUserId(Integer.valueOf(user_id));
        OrderInfoDto orderInfoDto=orderService.createOrder(orderCreateDto);

        return ResponseEntity.ok(orderInfoDto);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<OrderInfoDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.findAll());
    }
}
