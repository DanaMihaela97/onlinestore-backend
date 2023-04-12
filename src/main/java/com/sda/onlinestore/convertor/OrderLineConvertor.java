package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.entity.OrderLine;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Product;

public class OrderLineConvertor {

    public static OrderLine toEntity(Integer id, OrderLineDto orderLineDto,
                                     Product product, OrderList orderList){
        OrderLine orderLine = new OrderLine();
        orderLine.setId(id);
        orderLine.setProductPrice(orderLineDto.getProductPrice());
        orderLine.setNumberOfProducts(orderLineDto.getNumberOfProducts());
        orderLine.setProduct(product);
        orderLine.setOrderList(orderList);

        return orderLine;
    }

    public static OrderLineDto toDto(OrderLine orderLine){
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setProductPrice(orderLine.getProductPrice());
        orderLineDto.setNumberOfProducts(orderLine.getNumberOfProducts());
        orderLineDto.setProduct_id(orderLine.getProduct().getId());
        orderLineDto.setOrder_id(orderLine.getOrderList().getId());

        return orderLineDto;
    }
}
