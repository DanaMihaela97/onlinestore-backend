package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.OrderLine;

import java.util.List;

public class CartDto {
    private List<OrderLine> orderLine;

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }
}
