package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.OrderLineConvertor;
import com.sda.onlinestore.dto.OrderLineDto;
import com.sda.onlinestore.entity.OrderLine;
import com.sda.onlinestore.repository.OrderLineRepository;
import com.sda.onlinestore.repository.OrderRepository;
import com.sda.onlinestore.repository.ProductRepository;
import com.sda.onlinestore.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Autowired
        public OrderLineServiceImpl(OrderLineRepository orderLineRepository, OrderRepository orderRepository, ProductRepository productRepository) {
            this.orderLineRepository = orderLineRepository;
            this.orderRepository = orderRepository;
            this.productRepository = productRepository;
    }
    @Override
    public OrderLine createOrderLine(OrderLineDto orderLineDto){
        OrderLine orderLine = new OrderLine();
        orderLine.setProductPrice(orderLineDto.getProductPrice());
        orderLine.setNumberOfProducts(orderLineDto.getNumberOfProducts());
        orderLine.setProduct(productRepository.findById(orderLineDto.getProduct_id()).get());
        orderLine.setOrderList(orderRepository.findById(orderLineDto.getOrder_id()).get());

        return orderLineRepository.save(orderLine);
    }
    @Override
    public OrderLine getOrderLine(Integer order_id) {
        OrderLine orderList = orderLineRepository.findById(order_id).get();
        return orderList;
    }

    @Override
    public List<OrderLineDto> getOrderLines(String order_id) {
        List<OrderLine> orderLines = orderLineRepository.findAll();
        List<OrderLineDto> orderLineDtoList = orderLines.stream()
                .map(OrderLineConvertor::toDto)
                .filter(x -> x.getOrder_id().toString().equals(order_id))
                .toList();
        return orderLineDtoList;
    }
}

