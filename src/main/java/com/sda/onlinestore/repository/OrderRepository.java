package com.sda.onlinestore.repository;

import com.sda.onlinestore.entity.OrderList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderList, Integer> {
    List<OrderList> getAllOrdersByUserEmail(String user_email);
}
