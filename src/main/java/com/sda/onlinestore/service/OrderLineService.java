package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.entity.OrderLine;


import java.util.List;
import java.util.Optional;

public interface OrderLineService {
    OrderLine getOrderLine(Integer order_id);
    List<OrderLineDto> getOrderLines(String order_id);
    OrderLine createOrderLine(OrderLineDto orderLineDto);
}
