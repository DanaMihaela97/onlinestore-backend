package com.sda.onlinestore.controller;

import com.sda.onlinestore.convertor.OrderConvertor;
import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Status;
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

//    @PostMapping("/users/{email}/orders")
//    public ResponseEntity<OrderInfoDto> createOrder(@PathVariable String email, @RequestBody OrderCreateDto orderCreateDto){
//        orderCreateDto.setUser_email(email);
//        OrderInfoDto orderInfoDto=orderService.createOrder(orderCreateDto);
//
//        return ResponseEntity.ok(orderInfoDto);
//    }
    //update order
    @PutMapping("/users/{email}/orders/{order_id}")
    public ResponseEntity<OrderInfoDto> updateOrder(@PathVariable String email,
                                              @PathVariable String order_id,
                                              @RequestBody OrderInfoDto orderInfoDto) {
        return ResponseEntity.ok(orderService.updateOrder(email, order_id, orderInfoDto));
    }
    @PostMapping("/users/{email}/orders")
    public ResponseEntity<OrderList> createOrder(@PathVariable String email,
                                                    @RequestBody OrderInfoDto orderInfoDto){
        OrderList orderList = OrderConvertor.InfoToEntity(orderInfoDto, userService.findByEmail(email));
        orderService.save(orderList);

        return ResponseEntity.ok(orderList);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<OrderInfoDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @GetMapping("/users/{email}/orders/{order_id}")
    public ResponseEntity<OrderInfoDto> getOrderById(@PathVariable Integer order_id, @PathVariable String email){
        OrderInfoDto orderInfoDto = orderService.findById(order_id);
        return ResponseEntity.ok(orderInfoDto);
    }
    @GetMapping("/users/{email}/orders")
    public ResponseEntity<List<OrderList>> getOrdersByUserId(@PathVariable String email){
        List<OrderList> orderInfoDto = orderService.getOrdersByUserEmail(email);
        return ResponseEntity.ok(orderInfoDto);
    }
}
