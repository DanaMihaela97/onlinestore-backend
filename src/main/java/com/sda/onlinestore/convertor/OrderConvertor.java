package com.sda.onlinestore.convertor;


import com.sda.onlinestore.dto.OrderCreateDto;
import com.sda.onlinestore.dto.OrderInfoDto;
import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Status;
import com.sda.onlinestore.entity.User;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class OrderConvertor {

    public static OrderList toEntity(OrderCreateDto orderCreateDto, User user) {
        OrderList orderList = new OrderList();
        orderList.setPhoneNumber(orderCreateDto.getPhoneNumber());
        orderList.setTotalCost(orderCreateDto.getTotalCost());
        orderList.setCity(orderCreateDto.getCity());
        orderList.setDeliveryAddress(orderCreateDto.getDeliveryAddress());
        orderList.setDateOfSubmission(Date.from(
                orderCreateDto.getDateOfSubmission().toInstant(ZoneOffset.UTC)));
        orderList.setUser(user);
        orderList.setStatus(Status.PENDING);

        return orderList;
    }

    public static OrderInfoDto entityToInfo(OrderList orderList){
        OrderInfoDto orderInfoDto=new OrderInfoDto();
        orderInfoDto.setUser_id(orderList.getUser().getId());
        orderInfoDto.setTotalCost(orderList.getTotalCost());
        orderInfoDto.setDeliveryAddress(orderList.getDeliveryAddress());
        orderInfoDto.setDateOfSubmission(orderList.getDateOfSubmission());
        orderInfoDto.setCity(orderList.getCity());
        orderInfoDto.setPhoneNumber(orderList.getPhoneNumber());
        orderInfoDto.setOrder_status(orderList.getStatus().toString());
        return orderInfoDto;
    }

    public static OrderList InfoToEntity(OrderInfoDto orderInfoDto, User user) {
        OrderList orderList = new OrderList();

        orderList.setDeliveryAddress(orderInfoDto.getDeliveryAddress());
        orderList.setDateOfSubmission(orderInfoDto.getDateOfSubmission());
        orderList.setTotalCost(orderInfoDto.getTotalCost());
        orderList.setCity(orderInfoDto.getCity());
        orderList.setPhoneNumber(orderInfoDto.getPhoneNumber());
        orderList.setStatus(Status.valueOf(orderInfoDto.getOrder_status()));
        orderList.setUser(user);

        return orderList;
    }

}
