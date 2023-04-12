package com.sda.onlinestore.controller;

import com.sda.onlinestore.convertor.OrderLineConvertor;
import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.entity.OrderLine;
import com.sda.onlinestore.service.OrderLineService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/onlinestore")
public class OrderLineController {
    private final OrderLineService orderLineService;
    @Autowired
    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping("/users/{email}/orders/{order_id}/order_lines")
    public ResponseEntity<List<OrderLineDto>> getAllOrderLines(
            @PathVariable String email, @PathVariable String order_id){
        List<OrderLineDto> orderLineDtoList = orderLineService.getOrderLines(order_id);
        return ResponseEntity.ok(orderLineDtoList);
    }
    @PostMapping("/users/{email}/orders/{order_id}/order_lines")
    public ResponseEntity<OrderLineDto> createOrderLine(
            @PathVariable String email,
            @PathVariable String order_id,
            @RequestBody OrderLineDto orderLineDto){
        OrderLine orderLine = orderLineService.createOrderLine(orderLineDto);
        return ResponseEntity.ok(OrderLineConvertor.toDto(orderLine));
    }
}
